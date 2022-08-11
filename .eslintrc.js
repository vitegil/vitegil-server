module.exports = {
	'env': {
		'browser': true,
		'commonjs': true,
		'es2021': true,
		'node': true
	},
	'extends': [
		'eslint:recommended',
		'eslint-config-prettier' // prettier
	],
	'parserOptions': {
		'ecmaVersion': 'latest'
	},
	'plugins': [
		'eslint-plugin-prettier' // prettier
	],
	'rules': {
		'indent': [
			'error',
			'tab'
		],
		'linebreak-style': [
			'error',
			'windows'
		],
		'quotes': [
			'error',
			'single'
		],
		'semi': [
			'error',
			'always'
		],
		// 禁止空格和 tab 的混合缩进
		'no-mixed-spaces-and-tabs': 'warn',
	}
};
