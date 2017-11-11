import React, {Component} from 'react';

import Header from './header'
import FeedList from './feedList'
import WriteButton from './writeButton'

class App extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className="wrap">
                <Header/>
                <FeedList/>
                <WriteButton/>
            </div>
        );
    }
}

export default App