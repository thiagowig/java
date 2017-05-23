package br.com.ithiago.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Objects;

import br.com.ithiago.domain.enumeration.FinancialInstituition;

/**
 * A Simulation.
 */

@Document(collection = "simulation")
public class Simulation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("financial_instituition")
    private FinancialInstituition financialInstituition;

    @Field("property_value")
    private Integer propertyValue;

    @Field("using_fgts")
    private Boolean usingFgts;

    @Field("financial_value")
    private Integer financialValue;

    @Field("initial_value")
    private Integer initialValue;

    @Field("fgts_value")
    private Integer fgtsValue;

    @Field("months")
    private Integer months;

    @Field("tax")
    private Double tax;

    @Field("with_tr")
    private Boolean withTR;

    @Field("sac_installment")
    private Double sacInstallment;

    @Field("price_installment")
    private Double priceInstallment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FinancialInstituition getFinancialInstituition() {
        return financialInstituition;
    }

    public Simulation financialInstituition(FinancialInstituition financialInstituition) {
        this.financialInstituition = financialInstituition;
        return this;
    }

    public void setFinancialInstituition(FinancialInstituition financialInstituition) {
        this.financialInstituition = financialInstituition;
    }

    public Integer getPropertyValue() {
        return propertyValue;
    }

    public Simulation propertyValue(Integer propertyValue) {
        this.propertyValue = propertyValue;
        return this;
    }

    public void setPropertyValue(Integer propertyValue) {
        this.propertyValue = propertyValue;
    }

    public Boolean isUsingFgts() {
        return usingFgts;
    }

    public Simulation usingFgts(Boolean usingFgts) {
        this.usingFgts = usingFgts;
        return this;
    }

    public void setUsingFgts(Boolean usingFgts) {
        this.usingFgts = usingFgts;
    }

    public Integer getFinancialValue() {
        return financialValue;
    }

    public Simulation financialValue(Integer financialValue) {
        this.financialValue = financialValue;
        return this;
    }

    public void setFinancialValue(Integer financialValue) {
        this.financialValue = financialValue;
    }

    public Integer getInitialValue() {
        return initialValue;
    }

    public Simulation initialValue(Integer initialValue) {
        this.initialValue = initialValue;
        return this;
    }

    public void setInitialValue(Integer initialValue) {
        this.initialValue = initialValue;
    }

    public Integer getFgtsValue() {
        return fgtsValue;
    }

    public Simulation fgtsValue(Integer fgtsValue) {
        this.fgtsValue = fgtsValue;
        return this;
    }

    public void setFgtsValue(Integer fgtsValue) {
        this.fgtsValue = fgtsValue;
    }

    public Integer getMonths() {
        return months;
    }

    public Simulation months(Integer months) {
        this.months = months;
        return this;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    public Double getTax() {
        return tax;
    }

    public Simulation tax(Double tax) {
        this.tax = tax;
        return this;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Boolean isWithTR() {
        return withTR;
    }

    public Simulation withTR(Boolean withTR) {
        this.withTR = withTR;
        return this;
    }

    public void setWithTR(Boolean withTR) {
        this.withTR = withTR;
    }

    public Double getSacInstallment() {
        return sacInstallment;
    }

    public Simulation sacInstallment(Double sacInstallment) {
        this.sacInstallment = sacInstallment;
        return this;
    }

    public void setSacInstallment(Double sacInstallment) {
        this.sacInstallment = sacInstallment;
    }

    public Double getPriceInstallment() {
        return priceInstallment;
    }

    public Simulation priceInstallment(Double priceInstallment) {
        this.priceInstallment = priceInstallment;
        return this;
    }

    public void setPriceInstallment(Double priceInstallment) {
        this.priceInstallment = priceInstallment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Simulation simulation = (Simulation) o;
        if (simulation.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), simulation.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Simulation{" +
            "id=" + getId() +
            ", financialInstituition='" + getFinancialInstituition() + "'" +
            ", propertyValue='" + getPropertyValue() + "'" +
            ", usingFgts='" + isUsingFgts() + "'" +
            ", financialValue='" + getFinancialValue() + "'" +
            ", initialValue='" + getInitialValue() + "'" +
            ", fgtsValue='" + getFgtsValue() + "'" +
            ", months='" + getMonths() + "'" +
            ", tax='" + getTax() + "'" +
            ", withTR='" + isWithTR() + "'" +
            ", sacInstallment='" + getSacInstallment() + "'" +
            ", priceInstallment='" + getPriceInstallment() + "'" +
            "}";
    }
}
