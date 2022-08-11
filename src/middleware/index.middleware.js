// 全局中间件
const jwt = require('jsonwebtoken');

const { JWT_SECRET } = require('../config/config.default');
const { invalidToken } = require('../constants/err.type');

const authToken = async(ctx, next) => {
	const { Authorization } = ctx.request.header;
	try {
		// 解密token，获得用户id和其他信息，存储进ctx.state中
		const user = jwt.verify(Authorization, JWT_SECRET);
		ctx.state.user = user;
	} catch (error) {
		ctx.app.emit('error', invalidToken, ctx);
		ctx.body = {
			status: {
				code: 401,
				message: 'invalid token',
			}
		};
		return;
	}

	await next();
};

module.exports = {
	authToken,
};