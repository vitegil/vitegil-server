const { testBussinessError } = require('../constants/err.type');

class TestController {
	async responseDemo (ctx) {
		const data = ctx.request.body;
		try {
			ctx.body = {
				status: {
					code: 200,
					message: 'success',
				},
				data,
			};
		} catch (error) {
			console.error(error);
			ctx.app.emit('error', testBussinessError, ctx);
		}
	}
}

module.exports = new TestController();