const webpack = require("webpack");
const merge = require("webpack-merge");
const webpackConfigCommon = require('./webpack.config.common');

const webpackConfigProd = {
    plugins: [
        new webpack.optimize.UglifyJsPlugin({
            compress: {
                dead_code: true,
                warnings : false,
                drop_console: true
            },
            mangle: true,
            output: {
                comments: false,
                screw_ie8: true
            },
            sourceMap: false
        })
    ],
};

module.exports = merge(webpackConfigCommon, webpackConfigProd);