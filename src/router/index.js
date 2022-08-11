const fs = require('fs');

const Router = require('@koa/router');
const router = new Router();

// 循环获取所有路由
fs.readdirSync(__dirname).forEach(e => {
	if (e !== 'index.js') {
		let i = require('./' + e);
		router.use(i.routes());
	}
});

module.exports = router;