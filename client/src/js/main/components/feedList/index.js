import React, {Component} from 'react';

import Title from './Title'
import Feed from './Feed'
import Loading from './Loading'

import HttpClient from '../../../network/HttpClient'

class FeedList extends Component {

    constructor(props) {
        super(props);

        // CONSTANT
        this.INFINITE_SCROLL_OFFSET = 50;
        this.REQUEST_FEED_COUNT = 20;

        this.state = {
            fetch: false,
            feedList: [
                {
                    date: 'Nov. 11 2017',
                    title: '디프만 대나무숲, 모든이들의 자유로운 공간 1',
                    writer: '로로',
                    contents: '여기는 콘텐츠 영역 나랏말사미 듕긕에달아 문자와로 서로',
                    isDetail: false

                },
                {
                    date: 'Nov. 11 2017',
                    title: '디프만 대나무숲, 모든이들의 자유로운 공간 2',
                    writer: '디프만',
                    contents: '여기는 콘텐츠 영역입니다. 나랏말사미 듕긕에달아 문자와로 서로 사맛디 아니할세 이런 전챠로 어린 백셩이 니르고저 홀빼이셔도, 여기는 콘텐츠 영역 나랏말사미 듕긕에달아 문자와로 서로 사맛디 아니할세 이런 전챠로 어린 백셩이 니르고저 홀빼이셔도',
                    isDetail: false
                },
                {
                    date: 'Nov. 11 2017',
                    title: '디프만 대나무숲, 모든이들의 자유로운 공간 3',
                    writer: '디프만',
                    contents: '여기는 콘텐츠 영역입니다. 나랏말사미 듕긕에달아 문자와로 서로 사맛디 아니할세 이런 전챠로 어린 백셩이 니르고저 홀빼이셔도, 여기는 콘텐츠 영역 나랏말사미 듕긕에달아 문자와로 서로 사맛디 아니할세 이런 전챠로 어린 백셩이 니르고저 홀빼이셔도',
                    isDetail: false
                }
            ],
            offset: 0
        };

    }

    componentDidMount() {
        // todo fetch Feed List
        window.addEventListener('scroll', ::this.handleScrollEvent);
        new HttpClient().get(`/list.do?offset=${this.state.offset}&count=${this.REQUEST_FEED_COUNT}`)
            .then((response)=>{

            })
            .catch((e)=>{
                console.log('Network Error');
            })
    }

    handleScrollEvent(e) {
        if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight - this.INFINITE_SCROLL_OFFSET && this.state.fetch) {
            console.log("you're at the bottom of the page");
        }
    }

    handleClickFeed(e) {
        const selectedIndex = e.currentTarget.getAttribute('data-id');

        const feedList = this.state.feedList.map((item, index) => {
            if (index === Number(selectedIndex) && !item.isDetail) {
                item.isDetail = true;
            }
            else {
                item.isDetail = false;
            }
            return item;
        });

        this.setState({feedList});
    }

    render() {
        const feedList = this.state.feedList.map(({date, title, writer, contents, isDetail}, index) => {
            return (<Feed
                key={index}
                dataId={index}
                date={date}
                title={title}
                writer={writer}
                contents={contents}
                isDetail={isDetail}
                handleClickFeed={::this.handleClickFeed}
            />)
        });

        return (
            <div className="feedList">
                <Title/>
                {feedList}
                {this.state.fetch ? <Loading/> : ''}
            </div>
        );
    }
}

export default FeedList