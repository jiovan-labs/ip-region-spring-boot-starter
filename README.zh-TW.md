[English](README.md) | [簡體中文](README.zh-CN.md) | [繁體中文](README.zh-TW.md)

# IP 區域 Spring Boot Starter

讓 Spring Boot 應用快速整合 `IP2Region`，提供將 IP 地址解析為區域資訊的能力。

## 快速開始

- 匯入相依性

```xml
    <dependency>
        <groupId>com.jiovan.spring.starter</groupId>
        <artifactId>ip-region-spring-boot-starter</artifactId>
        <version>LATEST</version>
    </dependency>
```

> 預設情況下，此 starter 會自動生效，你可以透過 `jiovan.ip-region.enabled = false` 關閉它。

- 使用字首 `jiovan.ip-region` 設定 Spring Boot 的 `application.yml`

```yml
jiovan:
    ip-region:
        discard-lan: true
        region-db: 'classpath:/ipaddr/Ip2Region_20240228/ip2region.xdb'
```

- 透過建構函式或 `@Autowired`/`@Resource` 註解注入一個 `IpRegionResolver` Bean，然後即可用它解析位置資訊，如下所示：

| 方法返回值 | 方法名 |
|---------------|---------------------|
| String | getCompositeAddress |
| String | getRegionOutcome |

## 文件

- GitHub：https://github.com/jiovan-labs/ip-region-spring-boot-starter
- ip2region GitHub：https://github.com/lionsoul2014/ip2region

## 環境要求

- jdk 17+

## 許可證

本專案採用 [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0) 許可證。

請參閱 `NOTICE.txt` 檔案瞭解所需的宣告與歸屬資訊。

## 捐贈

喜歡這個工具包嗎？歡迎[向我們捐贈](https://jiovan.com/donation)以支援開發。

## 版權

北京玖漫科技有限公司

## 網站

- 玖漫：https://jiovan.com
