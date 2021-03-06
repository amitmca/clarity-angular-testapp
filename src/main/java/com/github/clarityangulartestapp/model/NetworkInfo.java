package com.github.clarityangulartestapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "network_info", schema = "netinfo")
public class NetworkInfo {
    @Id
    @SequenceGenerator(name = "network_info_generator", sequenceName = "network_info_seq", allocationSize = 1)
    @GeneratedValue(generator = "network_info_generator", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @NotNull(message = "The field 'ip' should not be empty")
    @Size(min = 7, max = 15, message = "Field 'ip' must be between 7 and 15 symbols")
    @Pattern(message = "Invalid 'ip' field format",
            regexp = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$")
    @Column(name = "ip")
    private String ip;

    @NotNull(message = "The field 'hostname' should not be empty")
    @Size(min = 1, max = 255, message = "Field 'hostname' must be between 1 and 255 symbols")
    @Column(name = "hostname")
    private String hostname;

    @Column(name = "create_user")
    private String createUser;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Override
    public String toString() {
        return "NetworkInfo [id=" + id + ", ip=" + ip + ", hostname=" + hostname + ", createUser=" + createUser + "]";
    }
}
