const app = require('./src/app/index');
const { APP_PORT } = require('./src/config/config.default');

app.listen(APP_PORT, () => {
	console.log(`Your server is running on http://localhost:${APP_PORT}`);
});