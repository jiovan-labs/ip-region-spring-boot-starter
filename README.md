[English](README.md) | [简体中文](README.zh-CN.md) | [繁體中文](README.zh-TW.md)

# IP Region Spring Boot Starter

Spring Boot application integrates `IP2Region` quickly, to provide abilities to resolve IP address to region.

## Quickstart

- Import dependencies

```xml
    <dependency>
        <groupId>com.jiovan.spring.starter</groupId>
        <artifactId>ip-region-spring-boot-starter</artifactId>
        <version>LATEST</version>
    </dependency>
```

> By default, this starter will auto take effect, you can turn it off by `jiovan.ip-region.enabled = false`

- Configure Spring Boot `application.yml` with prefix `jiovan.ip-region`

```yml
jiovan:
    ip-region:
        discard-lan: true
        region-db: 'classpath:/ipaddr/Ip2Region_20240228/ip2region.xdb'
```

- Configure your beans with a `IpRegionResolver` bean by constructor or `@Autowired`/`@Resource` annotation, then you can resolve locations with it as following:

| Method Return | Method Name         |
|---------------|---------------------|
| String        | getCompositeAddress |
| String        | getRegionOutcome    |

## Document

- Github: https://github.com/jiovan-labs/ip-region-spring-boot-starter
- Ip2region github: https://github.com/lionsoul2014/ip2region

## Requirement

- jdk 17+

## License

This project is under the [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)

See the `NOTICE.txt` file for required notices and attributions.

## Donation

You like this package? Then [donate to us](https://jiovan.com/donation) to support the development.

## Copyright

Beijing Jiovan Technology Ltd.

## Website

- Jiovan: https://jiovan.com
