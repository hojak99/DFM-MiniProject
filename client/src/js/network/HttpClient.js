import axios from 'axios'

export default function () {
    return axios({
        responseType: 'json'
    })
}