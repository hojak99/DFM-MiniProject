import React, {Component} from 'react';

class Feed extends Component {

    constructor(props) {
        super(props);
    };

    render() {
        const feedClassState = this.props.isDetail ? "feed detail" : "feed";

        return (
            <div className={feedClassState} data-id={this.props.dataId} onClick={this.props.handleClickFeed}>
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
                    <div>{this.props.contents}</div>
                </div>
            </div>
        );
    }
}

export default Feed