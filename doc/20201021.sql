-- auto-generated definition
create table city_config
(
    id            int(11) unsigned auto_increment comment '自增ID'
        primary key,
    city_id       int                                    not null comment '城市ID',
    district_name varchar(128) default ''                not null comment '区域名称',
    city_name     varchar(64)  default ''                not null comment '城市名称',
    province_name varchar(64)  default ''                not null comment '省份名称',
    lng           varchar(32)  default ''                not null comment '经度',
    lat           varchar(32)  default ''                not null comment '纬度',
    create_time   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
);

create index idx_city_name
    on city_config (city_name);

create index idx_district_name
    on city_config (district_name);

create index idx_province_name
    on city_config (province_name);



-- auto-generated definition
create table biz_focus
(
    id          int auto_increment
        primary key,
    biz_type    varchar(32)                            not null comment '业务类型',
    biz_data    varchar(512) default ''                not null comment '业务数据(json)',
    remark      varchar(64)  default ''                not null,
    create_time datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time datetime     default CURRENT_TIMESTAMP not null comment '更新时间'
)
    comment '业务关注表';



