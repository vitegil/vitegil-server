// middleware demo
const validateDemo = async(ctx, next) => {
	const data = ctx.request.body;
	console.log('sdk info', data);
	if (!data) {
		ctx.body = {
			status: {
				code: 400,
				message: 'params error',
			}
		};
		return;
	}
	
	return next();
};

module.exports = {
	validateDemo
};