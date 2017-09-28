package com.other.bean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Mail {

	  protected String subject;
	  protected String text;
	  protected String from;
	  protected String replyTo;
	  protected List<String> to = new ArrayList();

	  protected List<String> cc = new ArrayList();

	  protected List<String> bcc = new ArrayList();

	  protected List<File> attachements = new ArrayList();

	  public void addTo(String[] mails)
	  {
	    for (String mail : mails)
	      this.to.add(mail);
	  }

	  public void addCc(String[] mails)
	  {
	    for (String mail : mails)
	      this.cc.add(mail);
	  }

	  public void addBcc(String[] mails)
	  {
	    for (String mail : mails)
	      this.bcc.add(mail);
	  }

	  public void addAttachement(File attachement)
	  {
	    this.attachements.add(attachement);
	  }

	  public String getSubject() {
	    return this.subject;
	  }

	  public void setSubject(String subject) {
	    this.subject = subject;
	  }

	  public String getText() {
	    return this.text;
	  }

	  public void setText(String text) {
	    this.text = text;
	  }

	  public String getFrom() {
	    return this.from;
	  }

	  public void setFrom(String from) {
	    this.from = from;
	  }

	  public String getReplyTo() {
	    return this.replyTo;
	  }

	  public void setReplyTo(String replyTo) {
	    this.replyTo = replyTo;
	  }

	  public List<String> getTo() {
	    return this.to;
	  }

	  public void setTo(List<String> to) {
	    this.to = to;
	  }

	  public List<String> getCc() {
	    return this.cc;
	  }

	  public void setCc(List<String> cc) {
	    this.cc = cc;
	  }

	  public List<String> getBcc() {
	    return this.bcc;
	  }

	  public void setBcc(List<String> bcc) {
	    this.bcc = bcc;
	  }

	  public List<File> getAttachements() {
	    return this.attachements;
	  }

	  public void setAttachements(List<File> attachements) {
	    this.attachements = attachements;
	  }

}
