package com.monitoreo.modelo;

// Generated 20/06/2013 10:19:10 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Usuarios generated by hbm2java
 */
@Entity
@Table(name = "usuarios", schema = "public")
@NamedQueries({
	  @NamedQuery(name = "usuarios.autenticacion", query = "select u from Usuarios u LEFT JOIN u.direccionesips ud where u.login=:login and u.password=:password  and ud.usuarios.usuaid= u.usuaid and  ud.direccion =:ip"),
	  @NamedQuery(name = "usuarios.login", query = "select u from Usuarios u where u.login =:login") })
public class Usuarios implements java.io.Serializable {

	private int usuaid;
	private Roles roles;
	private Estados estados;
	private String usuanombre;
	private String usuapellido;
	private String usuamail;
	private String login;
	private String password;
	private Set<Direccionesip> direccionesips = new HashSet<Direccionesip>(0);
	private Set<Monitoreos> monitoreoses = new HashSet<Monitoreos>(0);
	private Set<Auditoria> auditorias = new HashSet<Auditoria>(0);

	public Usuarios() {
	}

	public Usuarios(int usuaid, Roles roles, Estados estados,
			String usuanombre, String usuapellido, String login, String password) {
		this.usuaid = usuaid;
		this.roles = roles;
		this.estados = estados;
		this.usuanombre = usuanombre;
		this.usuapellido = usuapellido;
		this.login = login;
		this.password = password;
	}

	public Usuarios(int usuaid, Roles roles, Estados estados,
			String usuanombre, String usuapellido, String usuamail,
			String login, String password, Set<Direccionesip> direccionesips,
			Set<Monitoreos> monitoreoses, Set<Auditoria> auditorias) {
		this.usuaid = usuaid;
		this.roles = roles;
		this.estados = estados;
		this.usuanombre = usuanombre;
		this.usuapellido = usuapellido;
		this.usuamail = usuamail;
		this.login = login;
		this.password = password;
		this.direccionesips = direccionesips;
		this.monitoreoses = monitoreoses;
		this.auditorias = auditorias;
	}

	@Id
	@Column(name = "usuaid", unique = true, nullable = false)
	public int getUsuaid() {
		return this.usuaid;
	}

	public void setUsuaid(int usuaid) {
		this.usuaid = usuaid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roles_rolid", nullable = false)
	public Roles getRoles() {
		return this.roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estados_estadoid", nullable = false)
	public Estados getEstados() {
		return this.estados;
	}

	public void setEstados(Estados estados) {
		this.estados = estados;
	}

	@Column(name = "usuanombre", nullable = false)
	public String getUsuanombre() {
		return this.usuanombre;
	}

	public void setUsuanombre(String usuanombre) {
		this.usuanombre = usuanombre;
	}

	@Column(name = "usuapellido", nullable = false)
	public String getUsuapellido() {
		return this.usuapellido;
	}

	public void setUsuapellido(String usuapellido) {
		this.usuapellido = usuapellido;
	}

	@Column(name = "usuamail")
	public String getUsuamail() {
		return this.usuamail;
	}

	public void setUsuamail(String usuamail) {
		this.usuamail = usuamail;
	}

	@Column(name = "login", nullable = false)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarios")
	public Set<Direccionesip> getDireccionesips() {
		return this.direccionesips;
	}

	public void setDireccionesips(Set<Direccionesip> direccionesips) {
		this.direccionesips = direccionesips;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarios")
	public Set<Monitoreos> getMonitoreoses() {
		return this.monitoreoses;
	}

	public void setMonitoreoses(Set<Monitoreos> monitoreoses) {
		this.monitoreoses = monitoreoses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarios")
	public Set<Auditoria> getAuditorias() {
		return this.auditorias;
	}

	public void setAuditorias(Set<Auditoria> auditorias) {
		this.auditorias = auditorias;
	}

}
