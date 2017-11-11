import React, {Component} from 'react';

class Header extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className="header">
                <div className="header-left">
                    <img src="/img/logo@2x.png"/>
                    <span>딮숲</span>
                </div>
                <div className="header-right">
                    <button className="write-button">작성하기</button>
                </div>
            </div>
        );
    }
}

export default Header