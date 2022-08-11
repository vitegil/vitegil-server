// 将根目录下的.env中的配置引入项目中
const dotenv = require('dotenv');
const path = require('path');

dotenv.config({
	path: path.resolve(__dirname, '../../.env')
});

module.exports = process.env;