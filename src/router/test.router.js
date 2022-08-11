const Router = require('@koa/router');

const { validateDemo } = require('../middleware/test.middleware');
const { responseDemo }  = require('../controller/test.controller');

const router = new Router({
	prefix: '/api/test'
});

router.get('/', async (ctx) => {
	ctx.body = {
		status: {
			code: 200,
			message: 'success',
		}
	};
});

router.post('/', validateDemo, responseDemo);

module.exports = router;
