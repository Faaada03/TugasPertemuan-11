/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author MyBook Hype AMD
 */
@Entity
@Table(name = "barang")
@NamedQueries({
    @NamedQuery(name = "Barang.findAll", query = "SELECT b FROM Barang b"),
    @NamedQuery(name = "Barang.findByNoSeri", query = "SELECT b FROM Barang b WHERE b.noSeri = :noSeri"),
    @NamedQuery(name = "Barang.findByNamaBarang", query = "SELECT b FROM Barang b WHERE b.namaBarang = :namaBarang"),
    @NamedQuery(name = "Barang.findByJenis", query = "SELECT b FROM Barang b WHERE b.jenis = :jenis"),
    @NamedQuery(name = "Barang.findByJumlah", query = "SELECT b FROM Barang b WHERE b.jumlah = :jumlah")})
public class Barang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "no_seri")
    private String noSeri;
    @Column(name = "nama_barang")
    private String namaBarang;
    @Column(name = "jenis")
    private String jenis;
    @Column(name = "jumlah")
    private Integer jumlah;

    public Barang() {
    }

    public Barang(String noSeri) {
        this.noSeri = noSeri;
    }

    public String getNoSeri() {
        return noSeri;
    }

    public void setNoSeri(String noSeri) {
        this.noSeri = noSeri;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noSeri != null ? noSeri.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barang)) {
            return false;
        }
        Barang other = (Barang) object;
        if ((this.noSeri == null && other.noSeri != null) || (this.noSeri != null && !this.noSeri.equals(other.noSeri))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "i.Barang[ noSeri=" + noSeri + " ]";
    }
    
}
