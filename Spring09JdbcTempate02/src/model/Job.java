package model;

public class Job {

	private String jobId;
	private String jobTitle;
	private Integer minsalary;
	private Integer maxsalary;

	public Job() {
	}

	public Job(String jobId, String jobTitle, Integer minsalary, Integer maxsalary) {
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.minsalary = minsalary;
		this.maxsalary = maxsalary;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Integer getMinsalary() {
		return minsalary;
	}

	public void setMinsalary(Integer minsalary) {
		this.minsalary = minsalary;
	}

	public Integer getMaxsalary() {
		return maxsalary;
	}

	public void setMaxsalary(Integer maxsalary) {
		this.maxsalary = maxsalary;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Job [jobId=");
		builder.append(jobId);
		builder.append(", jobTitle=");
		builder.append(jobTitle);
		builder.append(", minsalary=");
		builder.append(minsalary);
		builder.append(", maxsalary=");
		builder.append(maxsalary);
		builder.append("]");
		return builder.toString();
	}
}
