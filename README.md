# 基于Koa2.js的简单web服务器框架

## 安装

> 本项目使用[pnpm](https://www.pnpm.cn/)安装，如果您使用的是NPM或Yarn，请使用如下命令：
```bash
npm install -g pnpm
```

### 安装依赖

```bash
pnpm install
```

### 启动服务

```bash
node index.js
```
### 修改配置
> 本项目默认端口为5671，若您需要修改，请在根目录下创建`.env`文件并配置`APP_PORT`属性来修改端口号。

另外，所有配置都可以写入`.env`。如需区分生产和开发环境，请配置`.env.production`文件和`.env.development`文件。

## 目录结构

```bash
├─src
│  ├─app # 应用代码
│  │      error.js
│  │      index.js
│  │
│  ├─config # 配置文件
│  │      config.default.js
│  │      config.development.js
│  │      config.production.js
│  │
│  ├─constants # 常量文件
│  │      err.type.js
│  │
│  ├─controller # 控制器
│  │      test.controller.js
│  │
│  ├─db # 数据库目录
│  │      seq.js
│  │
│  ├─middleware # 中间件
│  │      index.middleware.js
│  │      test.middleware.js
│  │
│  ├─model # 数据模型层
│  ├─router # 路由
│  │      index.js
│  │      test.router.js
│  │
│  └─service # 业务逻辑层
├─static
|   └─images # 图片文件夹
|
├─.vscode
|   └─extension.json # 插件配置文件
|
├─.env # 配置文件
|
├─.env.development # 开发环境配置文件
|
└─.env.production # 生产环境配置文件
```
