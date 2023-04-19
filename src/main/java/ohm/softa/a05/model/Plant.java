package ohm.softa.a05.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public abstract class Plant implements Comparable<Plant> {
    double height;
    String family;
    String name;

    public Plant(String name, String family, double height) {
        if (name == null || family == null || height <= 0)
            throw new IllegalArgumentException();
        this.height = height;
        this.family = family;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.getName())
                .append(this.getFamily())
                .append(this.getHeight())
                .append(this.getColor())
                .toHashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Plant))
            return false;
        Plant plant = (Plant)o;
        return new EqualsBuilder()
                .append(this.getName(), plant.getName())
                .append(this.getFamily(), plant.getFamily())
                .append(this.getHeight(), plant.getHeight())
                .append(this.getColor(), plant.getColor())
                .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(this.getName())
                .append(this.getFamily())
                .append(this.getHeight())
                .append(this.getColor())
                .toString();
    }

    @Override
    public int compareTo(Plant o) {
        if (this.getHeight() < o.getHeight())
            return  -1;
        if (this.getHeight() > o.getHeight())
            return 1;
        if (this.getHeight() == o.getHeight())
            return 0;
        throw new IllegalArgumentException();
    }

    public double getHeight() {
        return height;
    }

    public String getFamily() {
        return family;
    }

    public String getName() {
        return name;
    }

    public abstract PlantColor getColor();
}
