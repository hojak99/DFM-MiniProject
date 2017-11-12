package org.dfm.miniproject.miniproject.dto;



import java.util.Date;

public class BoardDTO {
	private int seq;
	private String title;
	private String content;
	private String user_id;
	private String open_yn;
	private Date crt_time;
	private int offset;
	private int count;
	private int nextOffset;

	public int getSeq() {
		return seq;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getNextOffset() {
		return nextOffset;
	}

	public void setNextOffset(int nextOffset) {
		this.nextOffset = nextOffset;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getOpen_yn() {
		return open_yn;
	}

	public void setOpen_yn(String open_yn) {
		this.open_yn = open_yn;
	}

	public Date getCrt_time() {
		return crt_time;
	}

	public void setCrt_time(Date crt_time) {
		this.crt_time = crt_time;
	}

	@Override
	public String toString() {
		return "BoardDTO [seq=" + seq + ", title=" + title + ", content=" + content + ", user_id=" + user_id
				+ ", open_yn=" + open_yn + ", crt_time=" + crt_time + ", offset=" + offset + ", count=" + count
				+ ", nextOffset=" + nextOffset + "]";
	}


}
