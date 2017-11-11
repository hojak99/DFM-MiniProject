import React, {Component} from 'react';

class Feed extends Component {

    constructor(props) {
        super(props);
    };

    render() {
        return (
            <div className="feed">
                <div className="date">
                    <span>{this.props.date}</span>
                </div>
                <div className="title">
                    <span>{this.props.title}</span>
                </div>
                <div className="writer">
                    <span>{this.props.writer}</span>
                </div>
                <div className="contents">
                    <span>{this.props.contents}</span>
                </div>
            </div>
        );
    }
}

export default Feed