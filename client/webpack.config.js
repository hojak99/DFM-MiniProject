const webpack = require("webpack");
const path = require("path");

module.exports = {
    entry: {
        "bundle.main": "./src/js/main",
        "bundle.write": "./src/js/write",
        "bundle.admin": "./src/js/admin"
    },
    output: {
        filename: "[name].js",
        path: path.resolve(__dirname, "build")
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
    },
    plugins: [
        new webpack.HotModuleReplacementPlugin()
    ],
    devServer: {
        hot: true,
        inline: true,
        host: 'localhost',
        disableHostCheck: true,
        port: 3000,
        open: false,
        contentBase: "src",
        publicPath: "/js",
        watchOptions: {
            aggregateTimeout: 300,
            poll: 1000
        }
    },
    devtool : 'inline-source-map'
};
