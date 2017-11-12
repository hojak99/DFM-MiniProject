import axios from 'axios'

export default function () {
    return axios.create({
        responseType: 'json',
        "Accept-Encoding": "gzip,deflate"
    })
}