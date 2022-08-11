const path = require('path');

const koa = require('koa');
const body = require('koa-body');
const parameter = require('koa-parameter');
const static = require('koa-static');
const cors = require('koa2-cors');

const userRouter = require('../router');
const err = require('./error');

const app = new koa();

app
	.use(cors({
		// origin: 'http://localhost:5671', // 允许访问的域名
		origin: (ctx) => {
			if (ctx.url === '/api/test') {
				return '*';
			} else {
				return 'http://localhost:5671';
			}
		},
		allowMethods: ['GET', 'POST', 'PUT', 'DELETE'],
		allowHeaders: ['Content-Type', 'Authorization', 'Accept'],
	}))
	.use(body({
		multipart: true,
		formidable: {
			// 上传云端后，将后端文件放在/home/ftpuser/www/下，将该属性改为../../../images
			uploadDir: path.join(__dirname, '../../static/images'),
			keepExtensions: true
		},
		strict: false
	}))
	.use(static(path.join(__dirname, '../../static')))
	.use(parameter(app))
	.use(userRouter.routes())
	// 没有写的请求类型返回405错误
	.use(userRouter.allowedMethods());
    
app.on('error', err);

module.exports = app;