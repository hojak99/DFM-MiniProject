const webpack = require("webpack");
const merge = require("webpack-merge");
const webpackConfigCommon = require('./webpack.config.common');

const webpackConfigDev = {
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

module.exports = merge(webpackConfigCommon, webpackConfigDev);