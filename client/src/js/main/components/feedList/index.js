import React, {Component} from 'react';

import Title from './Title'
import Feed from './Feed'

class FeedList extends Component {

    constructor(props) {
        super(props);

        // CONSTANT
        this.INFINITE_SCROLL_OFFSET = 50;

        this.state = {
            fetch: false,
            feedList: [
                {
                    date: 'Nov. 11 2017',
                    title: '디프만 대나무숲, 모든이들의 자유로운 공간 1',
                    writer: '로로',
                    contents: '여기는 콘텐츠 영역.. 나랏말사미 듕긕에달아 문자와로 서로 사맛디 아니할세 이런 전챠로 어린 백셩이 니르고저 홀빼이셔도'

                }
            ]
        };

    }

    componentDidMount() {
        // todo fetch Feed List
        window.addEventListener('scroll', ::this.handleScrollEvent);
    }

    handleScrollEvent(e) {
        if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight - this.INFINITE_SCROLL_OFFSET && this.state.fetch) {
            console.log("you're at the bottom of the page");
        }
    }

    render() {
        const feedList = this.state.feedList.map(({date, title, writer, contents}, index) => {
            return (<Feed key={index} date={date} title={title} writer={writer} contents={contents}/>)
        });

        return (
            <div className="feedList">
                <Title/>
                {feedList}
            </div>
        );
    }
}

export default FeedList