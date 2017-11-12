const path = require("path");

module.exports = {
    entry: {
        "bundle.main": "./src/js/main",
        "bundle.write": "./src/js/write",
        "bundle.admin": "./src/js/admin"
    },
    output: {
        filename: "[name].js",
        path: path.resolve(__dirname, "../build")
    },
    module: {
        rules: [
            {
                test: /\.jsx?$/,
                exclude: /node_modules/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['env', 'stage-0', 'react']
                    }
                }
            }
        ],
    }
};