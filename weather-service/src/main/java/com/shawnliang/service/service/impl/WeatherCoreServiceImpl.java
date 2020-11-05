package com.shawnliang.service.service.impl;

import com.shawnliang.core.component.WeatherConvertComponent;
import com.shawnliang.core.utils.BeanUtil;
import com.shawnliang.core.utils.TimeUtil;
import com.shawnliang.service.service.AliWeatherThirdService;
import com.shawnliang.service.service.WeatherCoreService;
import com.shawnliang.weather.common.model.info.ali.AliWeatherBaseReqInfo;
import com.shawnliang.weather.common.model.resp.ali.AliMojiAqiForecast5Resp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiAqiForecast5Resp.DataBean.AqiForecastBean;
import com.shawnliang.weather.common.model.resp.ali.AliMojiAqiResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiConditionNowResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiConditionNowResp.DataBean.ConditionBean;
import com.shawnliang.weather.common.model.resp.ali.AliMojiForecast15DaysResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiForecast15DaysResp.DataBean.ForecastBean;
import com.shawnliang.weather.common.model.resp.ali.AliMojiForecast24HoursResp;
import com.shawnliang.weather.common.model.resp.ali.AliMojiForecast24HoursResp.DataBean.HourlyBean;
import com.shawnliang.weather.common.model.resp.ali.AliMojiIndexResp;
import com.shawnliang.weather.common.model.resp.index.BaseWeatherResp;
import com.shawnliang.weather.common.model.resp.index.Weather15DaysResp;
import com.shawnliang.weather.common.model.resp.index.Weather15DaysResp.Weather15InfoResp;
import com.shawnliang.weather.common.model.resp.index.Weather24HourResp;
import com.shawnliang.weather.common.model.resp.index.Weather24HourResp.Weather24HourInfoResp;
import com.shawnliang.weather.common.model.resp.index.WeatherConditionResp;
import com.shawnliang.weather.common.model.resp.index.WeatherConditionResp.WeatherDetailResp;
import com.shawnliang.weather.common.model.resp.index.WeatherLifeResp;
import com.shawnliang.weather.common.model.resp.index.WeatherLifeResp.WeatherLifeInfoResp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/10/27
 */
@Service
@Slf4j
public class WeatherCoreServiceImpl implements WeatherCoreService {

    @Autowired
    private AliWeatherThirdService aliWeatherThirdService;

    @Override
    public BaseWeatherResp getBaseWeatherResp(AliWeatherBaseReqInfo aliWeatherBaseReqInfo) {
        AliMojiConditionNowResp nowResp = aliWeatherThirdService
                .getConditionNowResp(aliWeatherBaseReqInfo);
        AliMojiAqiResp aqiResp = aliWeatherThirdService
                .getAqiResp(aliWeatherBaseReqInfo);
        AliMojiForecast24HoursResp forecast24HoursResp = aliWeatherThirdService
                .getForecast24HoursResp(aliWeatherBaseReqInfo);
        AliMojiAqiForecast5Resp aqiForecast5DaysResp = aliWeatherThirdService
                .getAqiForecast5DaysResp(aliWeatherBaseReqInfo);
        AliMojiForecast15DaysResp forecast15DaysResp = aliWeatherThirdService
                .getForecast15DaysResp(aliWeatherBaseReqInfo);

        return buildBaseWeatherResp(nowResp, aqiResp, forecast24HoursResp,
                aqiForecast5DaysResp, forecast15DaysResp);
    }

    @Override
    public Weather15DaysResp get15DaysWeatherResp(AliWeatherBaseReqInfo aliWeatherBaseReqInfo) {
        AliMojiForecast15DaysResp forecast15DaysResp = aliWeatherThirdService
                .getForecast15DaysResp(aliWeatherBaseReqInfo);

        return build15DaysResp(forecast15DaysResp);
    }

    @Override
    public WeatherLifeResp getWeatherLife(AliWeatherBaseReqInfo aliWeatherBaseReqInfo) {
        AliMojiIndexResp indexResp = aliWeatherThirdService.getIndexResp(aliWeatherBaseReqInfo);

        return buildLifeResp(indexResp);
    }

    /**
     * 构造生活指数
     * @param indexResp
     * @return
     */
    private WeatherLifeResp buildLifeResp(AliMojiIndexResp indexResp) {
        WeatherLifeResp weatherLifeResp = new WeatherLifeResp();

        List<WeatherLifeInfoResp> weatherLifeInfoResps = BeanUtil
                .copyPropertiesJson(indexResp.getData().getResults(), WeatherLifeInfoResp.class);
        weatherLifeResp.setWeatherLifeInfoRespList(weatherLifeInfoResps);
        return weatherLifeResp;
    }

    /**
     * 构造15天的天气展示
     * @param forecast15DaysResp
     * @return
     */
    private Weather15DaysResp build15DaysResp(AliMojiForecast15DaysResp forecast15DaysResp) {
        Weather15DaysResp weather15DaysResp = new Weather15DaysResp();

        List<Weather15InfoResp> weather15InfoRespList = Lists.newArrayList();

        for (ForecastBean forecastBean : forecast15DaysResp.getData().getForecast()) {
            ArrayList<Integer> temps = Lists.newArrayList();
            log.info("日期是 ：{}", forecastBean.getPredictDate());
            Weather15InfoResp weather15InfoResp = BeanUtil
                    .copyPropertiesJson(forecastBean, Weather15InfoResp.class);

            // 对日期进行封装
            LocalDate date = TimeUtil
                    .formatDateFromString(forecastBean.getPredictDate(), "yyyy-MM-dd");
            weather15InfoResp.setDate(TimeUtil.formatFromDate(date, "MM/dd"));
            weather15InfoResp.setDateDesc(TimeUtil.getDateDesc(date));

            temps.add(Integer.parseInt(forecastBean.getTempDay()));
            temps.add(Integer.parseInt(forecastBean.getTempNight()));

            // 进行排序
            Collections.sort(temps);

            weather15InfoResp.setHighTemp(temps.get(temps.size() - 1));
            weather15InfoResp.setLowTemp(temps.get(0));

            weather15InfoResp.setWindDesc(StringUtils.join(forecastBean.getWindLevelDay(), "级"));

            weather15InfoRespList.add(weather15InfoResp);
        }
        weather15DaysResp.setWeather15InfoRespList(weather15InfoRespList);
        return weather15DaysResp;
    }

    /**
     * 构建基本天气数据展示
     * @param nowResp
     * @param aqiResp
     * @return
     */
    private BaseWeatherResp buildBaseWeatherResp(AliMojiConditionNowResp nowResp,
            AliMojiAqiResp aqiResp, AliMojiForecast24HoursResp forecast24HoursResp,
            AliMojiAqiForecast5Resp aqiForecast5DaysResp, AliMojiForecast15DaysResp forecast15DaysResp) {
        ConditionBean condition = nowResp.getData().getCondition();
        BaseWeatherResp baseWeatherResp = new BaseWeatherResp();
        Weather24HourResp weather24HourResp = new Weather24HourResp();
        baseWeatherResp.setWeather24HourResp(weather24HourResp);

        WeatherConditionResp weatherConditionResp = BeanUtil
                .copyPropertiesJson(condition, WeatherConditionResp.class);
        weatherConditionResp.setHumidity(condition.getHumidity() + "%");
        weatherConditionResp.setWindLevel(condition.getWindLevel() + "级");

        // 设置基本天气
        String value = aqiResp.getData().getAqi().getValue();
        weatherConditionResp.setAirValue(value);
        weatherConditionResp.setAirDesc(WeatherConvertComponent.getAqiDesc(Integer.valueOf(value)));

        // 获取今明两天的天气
        List<WeatherDetailResp> weatherDetailRespList = getWeatherDetail(aqiForecast5DaysResp, forecast15DaysResp);
        weatherConditionResp.setWeatherDetailRespList(weatherDetailRespList);
        // 设置24小时天气
        ArrayList<Integer> dailyTemps = Lists.newArrayList();
        List<HourlyBean> hourly = forecast24HoursResp.getData().getHourly();
        List<Weather24HourInfoResp> weather24HourInfoRespList = Lists.newArrayList();
        for (HourlyBean hourlyBean : hourly) {
            Weather24HourInfoResp entity = new Weather24HourInfoResp();
            entity.setCondition(hourlyBean.getCondition());
            entity.setTemp(hourlyBean.getTemp());
            entity.setTime(StringUtils.join(hourlyBean.getHour(), ":00"));
            entity.setWindLevel(WeatherConvertComponent.
                    getWindLevelBySpeed(Double.parseDouble(hourlyBean.getWindSpeed())).toString());

            dailyTemps.add(Integer.valueOf(hourlyBean.getTemp()));
            weather24HourInfoRespList.add(entity);
        }
        Collections.sort(dailyTemps);

        weather24HourResp.setWeather24HourInfoRespList(weather24HourInfoRespList);
        weather24HourResp.setHighTemp(dailyTemps.get(dailyTemps.size() -1).toString());
        weather24HourResp.setLowTemp(dailyTemps.get(0).toString());


        // 日出日落时间设置
        LocalDateTime sunRiseTime = TimeUtil
                .formatTimeFromString(condition.getSunRise(), "yyyy-MM-dd HH:mm:ss");
        LocalDateTime sunSetTime = TimeUtil
                .formatTimeFromString(condition.getSunSet(), "yyyy-MM-dd HH:mm:ss");
        weather24HourResp.setSunRise(TimeUtil.formatFromDateTime(sunRiseTime, "HH:mm"));
        weather24HourResp.setSunSet(TimeUtil.formatFromDateTime(sunSetTime, "HH:mm"));

        baseWeatherResp.setConditionResp(weatherConditionResp);
        return baseWeatherResp;
    }

    /**
     * 获取今明两天的天气
     * @param aqiForecast5DaysResp
     * @param forecast15DaysResp
     * @return
     */
    private List<WeatherDetailResp> getWeatherDetail(AliMojiAqiForecast5Resp aqiForecast5DaysResp,
            AliMojiForecast15DaysResp forecast15DaysResp) {
        LocalDate now = LocalDate.now();
        String today = TimeUtil.formatFromDate(now, "yyyy-MM-dd");
        String tomorrow = TimeUtil.formatFromDate(now.plusDays(1), "yyyy-MM-dd");
        List<ForecastBean> beanList = forecast15DaysResp.getData().getForecast().stream()
                .filter(s -> today.equals(s.getPredictDate())
                        || tomorrow.equals(s.getPredictDate())).
                        sorted(Comparator.comparing(ForecastBean::getPredictDate)).
                        collect(Collectors.toList());
        Map<String, AqiForecastBean> date5DaysForeCastMap = aqiForecast5DaysResp.getData().getAqiForecast().
                stream().
                collect(Collectors.toMap(AqiForecastBean::getDate, Function.identity()));

        List<WeatherDetailResp> respList = Lists.newArrayList();
        List<Integer> temps = Lists.newArrayList();
        for (ForecastBean day15Bean : beanList) {
            WeatherDetailResp entity = new WeatherDetailResp();

            temps.add(Integer.parseInt(day15Bean.getTempDay()));
            temps.add(Integer.parseInt(day15Bean.getTempNight()));
            Collections.sort(temps);

            entity.setLowTemp(temps.get(0));
            entity.setHighTemp(temps.get(temps.size() -1));
            entity.setDateDesc(today.equals(day15Bean.getPredictDate()) ? "今天" : "明天");
            entity.setDetailCondition(day15Bean.getConditionDay());
            AqiForecastBean aqi5DayBean = date5DaysForeCastMap.get(day15Bean.getPredictDate());
            if (aqi5DayBean != null) {
                entity.setDetailAirDesc(WeatherConvertComponent.getAqiDesc(aqi5DayBean.getValue()));
            }

            respList.add(entity);
            temps.clear();
        }
            return respList;
    }
}
