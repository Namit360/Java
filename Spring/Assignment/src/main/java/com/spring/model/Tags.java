package com.spring.model;
import javax.persistence.Embeddable;

@Embeddable
public class Tags 
{
	public int tagid;
	public String tagdesc;
	public int getTagid() {
		return tagid;
	}
	public void setTagid(int tagid) {
		this.tagid = tagid;
	}
	public String getTagdesc() {
		return tagdesc;
	}
	public void setTagdesc(String tagdesc) {
		this.tagdesc = tagdesc;
	}
}
