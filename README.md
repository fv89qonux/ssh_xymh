## 本项目实现的最终作用是基于SSH在线田园农场网站平台管理系统
## 分为1个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 产品管理
 - 产品类型管理
 - 新闻管理
 - 管理员登录
 - 网址配备管理
 - 荣誉管理
 - 轮播图管理
## 数据库设计如下：
# 数据库设计文档

**数据库名：** ssh_xymh

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [about](#about) | 关于我们信息表 |
| [banner](#banner) |  |
| [config](#config) |  |
| [honor](#honor) |  |
| [manage](#manage) |  |
| [news](#news) | 新闻资讯表 |
| [product](#product) | 商品信息表 |
| [pro_type](#pro_type) |  |

**表名：** <a id="about">about</a>

**说明：** 关于我们信息表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | title |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 标题  |
|  3   | content |   varchar   | 20000 |   0    |    Y     |  N   |   NULL    | 内容  |
|  4   | addTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 添加时间  |

**表名：** <a id="banner">banner</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | content |   varchar   | 20000 |   0    |    Y     |  N   |   NULL    | 内容  |
|  3   | addTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 添加时间  |
|  4   | title |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 标题  |

**表名：** <a id="config">config</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 公司名称  |
|  3   | web |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 公司网址  |
|  4   | address |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 公司地址  |
|  5   | email |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 公司邮编  |
|  6   | tel |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 公司电话  |
|  7   | beian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 公司备案  |
|  8   | introduce |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 公司介绍  |

**表名：** <a id="honor">honor</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | image |   varchar   | 1000 |   0    |    Y     |  N   |   NULL    |   |
|  3   | addTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 添加时间  |
|  4   | title |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 标题  |
|  5   | content |   varchar   | 20000 |   0    |    Y     |  N   |   NULL    | 内容  |

**表名：** <a id="manage">manage</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | username |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户名  |
|  3   | password |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |
|  4   | nickname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 昵称  |
|  5   | isDelete |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="news">news</a>

**说明：** 新闻资讯表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | title |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 标题  |
|  3   | content |   varchar   | 20000 |   0    |    Y     |  N   |   NULL    | 内容  |
|  4   | addTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 添加时间  |
|  5   | addUserId |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="product">product</a>

**说明：** 商品信息表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | image |   varchar   | 1000 |   0    |    Y     |  N   |   NULL    |   |
|  3   | addTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 添加时间  |
|  4   | title |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 标题  |
|  5   | content |   varchar   | 20000 |   0    |    Y     |  N   |   NULL    | 内容  |
|  6   | type |   int   | 10 |   0    |    Y     |  N   |   NULL    | 类型  |

**表名：** <a id="pro_type">pro_type</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | title |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 标题  |

