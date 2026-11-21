[English](README.md) | [简体中文](README.zh-CN.md) | [繁體中文](README.zh-TW.md)

# IP 区域 Spring Boot Starter

让 Spring Boot 应用快速集成 `IP2Region`，提供将 IP 地址解析为区域信息的能力。

## 快速开始

- 导入依赖

```xml
    <dependency>
        <groupId>com.jiovan.spring.starter</groupId>
        <artifactId>ip-region-spring-boot-starter</artifactId>
        <version>LATEST</version>
    </dependency>
```

> 默认情况下，此 starter 会自动生效，你可以通过 `jiovan.ip-region.enabled = false` 关闭它。

- 使用前缀 `jiovan.ip-region` 配置 Spring Boot 的 `application.yml`

```yml
jiovan:
    ip-region:
        discard-lan: true
        region-db: 'classpath:/ipaddr/Ip2Region_20240228/ip2region.xdb'
```

- 通过构造函数或 `@Autowired`/`@Resource` 注解注入一个 `IpRegionResolver` Bean，然后即可用它解析位置信息，如下所示：

| 方法返回值 | 方法名 |
|---------------|---------------------|
| String | getCompositeAddress |
| String | getRegionOutcome |

## 文档

- GitHub：https://github.com/jiovan-labs/ip-region-spring-boot-starter
- ip2region GitHub：https://github.com/lionsoul2014/ip2region

## 环境要求

- jdk 17+

## 许可证

本项目采用 [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0) 许可证。

请参阅 `NOTICE.txt` 文件了解所需的声明与归属信息。

## 捐赠

喜欢这个工具包吗？欢迎[向我们捐赠](https://jiovan.com/donation)以支持开发。

## 版权

北京玖漫科技有限公司

## 网站

- 玖漫：https://jiovan.com
