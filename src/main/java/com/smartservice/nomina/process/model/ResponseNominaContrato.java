package com.smartservice.nomina.process.model;

import java.util.Date;
import java.util.Map;

public class ResponseNominaContrato {

    private long idContract;
    private long document;
    private String employeeName;
    private Date startDate;
    private Date retirementDate;
    private long salary;
    private int workedDays;
    private long pay;
    private Map<String, NominaNovedad > changesPayroll;
    private long totalAccrued;
    private long totalDeducted;
    private long netPay;

    public long getIdContract() {
        return idContract;
    }

    public void setIdContract(long idContract) {
        this.idContract = idContract;
    }

    public long getDocument() {
        return document;
    }

    public void setDocument(long document) {
        this.document = document;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getRetirementDate() {
        return retirementDate;
    }

    public void setRetirementDate(Date retirementDate) {
        this.retirementDate = retirementDate;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public int getWorkedDays() {
        return workedDays;
    }

    public void setWorkedDays(int workedDays) {
        this.workedDays = workedDays;
    }

    public long getPay() {
        return pay;
    }

    public void setPay(long pay) {
        this.pay = pay;
    }

    public Map<String, NominaNovedad> getChangesPayroll() {
        return changesPayroll;
    }

    public void setChangesPayroll(Map<String, NominaNovedad> changesPayroll) {
        this.changesPayroll = changesPayroll;
    }

    public long getTotalAccrued() {
        return totalAccrued;
    }

    public void setTotalAccrued(long totalAccrued) {
        this.totalAccrued = totalAccrued;
    }

    public long getTotalDeducted() {
        return totalDeducted;
    }

    public void setTotalDeducted(long totalDeducted) {
        this.totalDeducted = totalDeducted;
    }

    public long getNetPay() {
        return netPay;
    }

    public void setNetPay(long netPay) {
        this.netPay = netPay;
    }
}
