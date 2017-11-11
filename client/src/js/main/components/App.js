import React, {Component} from 'react';
import Header from './header'
import FeedList from './feedList'
class App extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className="wrap">
                <Header/>
                <FeedList/>
            </div>
        );
    }
}

export default App