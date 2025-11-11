/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stjean.tptestu1_bilogue_seme;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kseme
 */
public class Utilisateur {
    private int id;
    private String nom;
    private int age;
    private String email;
    private String telephone;
    private String ville;
    private double soldePersonnel;
    private static ArrayList<Utilisateur> users = new ArrayList<>();
    
    
    public Utilisateur(int id, String nom, int age, String email, String telephone, String ville, double soldePersonnel) {
        this.setId(id);
        this.setNom(nom);
        this.setAge(age);
        this.setEmail(email);
        this.setTelephone(telephone);
        this.setVille(ville);
        this.setSoldePersonnel(soldePersonnel);
    }
    private static boolean validerEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    public static void ajouter(Utilisateur user) throws EmailInvalidException {
        if (!validerEmail(user.email)) {
            throw new EmailInvalidException("Email invalide : format incorrect.");
        }
        users.add(user);
    }

	public double getSoldePersonnel() {
		return soldePersonnel;
	}


	public void setSoldePersonnel(double soldePersonnel) {
		this.soldePersonnel = soldePersonnel;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
        
        public static void supprimer(int id) throws SuppressionInvalidException {
        boolean trouve = false;
        for (Utilisateur u : users) {
            if (u.id == id) {
                users.remove(u);
                trouve = true;
                break;
            }
        }
        if (!trouve) {
            throw new SuppressionInvalidException("Utilisateur avec ID " + id + " inexistant.");
        }
    }
        public static List<Utilisateur> lister() {
        return new ArrayList<>(users);
    }
        public static double analyseSoldeGeneral() throws NegativeGeneralBalanceException {
        double total = 0;
        for (Utilisateur u : users) {
            total += u.soldePersonnel;
        }
        if (total < 0) {
            throw new NegativeGeneralBalanceException("Solde général négatif : " + total);
        }
        return total;
    }
    
    /**
     * Retourne l'utilisateur le plus riche.
     * @return Utilisateur
     */
    public static Utilisateur utilisateurLePlusRiche() {
        if (users.isEmpty()) {
            return null;
        }
        Utilisateur riche = users.get(0);
        for (Utilisateur u : users) {
            if (u.soldePersonnel > riche.soldePersonnel) {
                riche = u;
            }
        }
        return riche;
    }
    
    // toString pour affichage
    @Override
    public String toString() {
        return "Utilisateur [id=" + id + ", nom=" + nom + ", solde=" + soldePersonnel + "]";
    }
    public static Utilisateur afficher(int id) {
        for (Utilisateur u : users) {
            if (u.id == id) {
                return u;
            }
        }
        return null;
    }
}
