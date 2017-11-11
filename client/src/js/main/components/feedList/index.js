import React, {Component} from 'react';

import Title from './Title'
import Feed from './Feed'

class App extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className="feedList">
                <Title/>
                <Feed/>
            </div>
        );
    }
}

export default App