#include<iostream>
#include<stdio.h>
#include<string.h>
#include <conio.h>

using namespace std;

class Participant {
private:
	char* nume;
	const int id;
	float* inaltime;
	int varsta;
	static int nrTotalP; //nrTotalP = contor ca sa tin eu minte 

	/*
	- la linia de mai sus am comentariu "ca sa tin eu minte", dar ar fi trebuit sa pun in denumirea 
	variabilei ceva sugestiv, in felul acesta nu mai era nevoie de el
	- tot legat de denumirea variabilei, aceasta nu este destul de intuitiva, mi-a luat putin sa-mi dau seama de ce este P acolo
	*/


	//CONSTRUCTOR FARA PARAMETRI
public:
	Participant() :id(nrTotalP++) {
		this->nume = NULL;
		this->inaltime = NULL;
		this->varsta = 20;
		cout << "S-a apelat constructorul fara parametri!" << endl;
	}

	//CONSTRUCTOR CU 1 PARAMETRU
	Participant(int varsta) :id(nrTotalP++) {
		this->varsta = varsta;
		this->nume = NULL;
		this->inaltime = NULL;
		cout << "S-a apelat constructor cu 1 parametru" << endl;
	}

	//CONSTRUCTOR CU TOTI PARAMETRII
	Participant(char* nume, float* inaltime, int vasrta) :id(nrTotalP++) {
		this->nume = new char[strlen(nume) + 1];
		strcpy(this->nume, nume);
		this->inaltime = new float[nrTotalP];
		for (int i = 0; i < nrTotalP; i++)
			this->inaltime[i] = inaltime[i];
		this->varsta = varsta;
		cout << "S-a apelat si constructorul cu TOTI parametrii!" << endl;
	}

	//CONSTRUCTOR DE COPIERE
	Participant(const Participant& p) :id(nrTotalP++) {
		this->nume = new char[strlen(p.nume) + 1];
		strcpy(this->nume, p.nume);
		this->inaltime = new float[p.nrTotalP];
		for (int i = 0; i < p.nrTotalP; i++)
			this->inaltime[i] = p.inaltime[i];
		this->varsta = p.varsta;
		cout << "S-a apelat CONSTRUCTORUL DE COPIERE!" << endl;
	}

	//SUPRAINCARCARE OPERATOR =
	Participant& operator=(const Participant& p) {
		this->nume = new char[strlen(p.nume) + 1];
		strcpy(this->nume, p.nume);
		this->inaltime = new float[p.nrTotalP];
		for (int i = 0; i < p.nrTotalP; i++)
			this->inaltime[i] = p.inaltime[i];
		this->varsta = p.varsta;
		cout << "S-a apelat OPERATORUL =!!!!!!" << endl;
		return *this;
	}

	//SUPRAINCARCARE <<
	friend ostream& operator<<(ostream& out, Participant& p) {
		out << "Nume: " << p.nume << endl;
		for (int i = 0; i<p.nrTotalP; i++)
			out << "Inaltime participant " << i + 1 << ":" << p.inaltime[i] << endl;
		out << "Varsta: " << p.varsta << endl;
		out << "Numarul total de obiecte create este: " << p.nrTotalP << endl;
		return out;
	}

	//SUPRAINCARCARE >>
	friend istream& operator>>(istream& in, Participant& p) {
		cout << "Nume:";
		in >> p.nume;
		for (int i = 0; i < p.nrTotalP; i++) {
			cout << "Inaltime participant " << i + 1 << ":";
			in >> p.inaltime[i];
		}
		cout << "Varsta: ";
		in >> p.varsta;
		cout << "Numarul total de obiecte create este: " << p.nrTotalP << endl;
		return in;
	}

	//Supraincarcare OPERATOR DE INDEXARE []
	float& operator [](int index) {
		if (index<0 || index> this->nrTotalP) {
			cout << "Hey u, ai depasit limita!!" << endl;
			throw new exception("Exceptie*");
		}
		else return this->inaltime[index];
	}

	//SUPRAINCARCARE OPERATOR CAST la float
	explicit operator float() {
		return *this->inaltime;
	}

	//SUPRAINCARCARE OPEEATOR + pentru apel p1+5
	Participant operator+(int varsta) {
		Participant copie = *this;
		copie.varsta = copie.varsta + varsta;
		return copie;
	}

	//SUPRAINCARCARE OPEEATOR - pentru apel p1-5
	Participant operator-(int varsta) {
		Participant copie = *this;
		copie.varsta = copie.varsta - varsta;
		return copie;
	}

	// SUPRAINCARCARE operator ++ prefixat; ++p1; adaugam un nou participant
	Participant operator++()
	{
		this->nume++;
		return *this;
	}

	//SUPRAINCARCARE operator postincrementare
	Participant operator++(int)
	{
		Participant copie = *this;
		this->nume++;
		return copie;
	}

	//SUPRAINCARCARE OPERATOR ==
	bool operator == (Participant p) {
		if (this->nume == p.nume&& this->varsta == p.varsta)
			return true;
		else
			return false;
	}

	//SUPRAINCARCARE >= verificare varsta a doi participanti
	//() varsta primului participant mai mare sau egala decat varsta participantului 2
	bool operator>=(Participant p) {
		if (this->varsta == p.varsta)
			return true;
		else
			return false;
	}

	//OPERATORUL DE NEGATIE
	bool operator!() {
		if (this->inaltime != NULL)
			return false;
		else
			return true;
	}

	//DESTRUCTOR
	~Participant() {
		if (this->nume != NULL) {
			delete[]this->nume;
		}
		if (this->inaltime != NULL) {
			delete[]this->inaltime;
		}
		cout << "S-a apelat destructor PARTICIPANT!" << endl;
	}

	//FUNCTIE DE AFISARE
	void afisare() {
		printf("Nume: %s \n", this->nume);
		for (int i = 0; i<nrTotalP; i++)
			cout << "Inaltime participant " << i + 1 << ":" << this->inaltime << endl;
		cout << "Varsta: " << this->varsta << endl;
		cout << "Numarul total de obiecte create este: " << this->nrTotalP << endl;
	}


	//functie de verificare varsta
	bool validareNumar(const char* p) {
		for (int i = 0; i < strlen(p); i++)
			if (isdigit(p[i]) == false)
				return false;
			else return true;
	}


	//setter varsta
	void setVarsta(int varsta) {
		if (varsta <= 10)
			cout << "Nu puteti participa!" << endl;
		else this->varsta = varsta;
	}


	//setter nume
	void setNume(const char* nume) {
		while (validareNumar(nume)) {
			cout << "Vezi, ba, ca ai introdus cifre in NAME!!" << endl;
			scanf("%s", nume);
		}
		this->nume = new char[strlen(nume) + 1];
		strcpy(this->nume, nume);

	}

	//setter inaltime
	void setInaltime(float* inaltime, int nrTotalP) {
		this->nrTotalP = nrTotalP;
		if (this->inaltime != NULL)
			delete[]this->inaltime;
		this->inaltime = new float[nrTotalP];
		for (int i = 0; i < nrTotalP; i++)
			this->inaltime[i] = inaltime[i];
	}

	//getter varsta
	int getVarsta() {
		return this->varsta;
	}
	//getter pentru nume
	const char* getNume() {
		return nume;
	}

	//getter inaltime
	float* getInaltime() {
		return this->inaltime;
	}
};
int Participant::nrTotalP = 1;

//--------------------------------------------------------------------------------------------------------------------------------------------
class Probe {
private:
	const int id;
	/*
	- am denumit si aici doar id simplu, dar mai am si la clasa Participant la fel si exista posibilitatea sa le incurc la un moment dat
	*/
	static int nrProbe;
	char* numeProba;
	float* punctajProba;

	//CONSTRUCTOR FARA PARAMETRI
public:
	Probe() :id(nrProbe++) {
		this->numeProba = NULL;
		this->punctajProba = NULL;
		cout << "S-a apelat constructorul fara parametrii PROBE!" << endl;
	}

	//CONSTRUCTOR CU 1 PARAMETRU
	Probe(char* numeProba) :id(nrProbe++) {
		this->numeProba = new char[strlen(numeProba) + 1];
		strcpy(this->numeProba, numeProba);
		this->punctajProba = NULL;
		cout << "S-a apelat constructorul cu 1 parametru PROBE!" << endl;
	}

	//CONSTRUCTOR CU TOTI PARAMETRII
	Probe(char* numeProba, float* punctajProba) :id(nrProbe++) {
		this->numeProba = new char[strlen(numeProba) + 1];
		strcpy(this->numeProba, numeProba);
		this->punctajProba = new float[nrProbe];
		for (int i = 0; i < nrProbe; i++) {
			this->punctajProba[i] = punctajProba[i];
		}
		cout << "S-a apelat constructorul cu TOTI parametrii PROBE!" << endl;
	}

	//DESTRUCTOR
	~Probe() {
		if (this->numeProba != NULL)
			delete[]this->numeProba;
		if (this->punctajProba != NULL)
			delete[]this->punctajProba;
		cout << "S-a apelat destructor PROBE!" << endl;
	}

	//setter numeProba
	void setNumeProba(char* numeProba, int nrProbenou) {
		if (this->numeProba != NULL) {
			delete[] this->numeProba;
		}
		this->nrProbe = nrProbenou;
		this->numeProba = new char[this->nrProbe];
		for (int i = 0; i < this->nrProbe; i++) {
			this->numeProba[i] = numeProba[i];
		}
	}

	//setter punctajProba
	void setPunctajProba(float* punctajProba, int nrProbe) {
		this->nrProbe = nrProbe;
		if (this->punctajProba != NULL)
			delete[]this->punctajProba;
		this->punctajProba = new float[nrProbe];
		for (int i = 0; i < nrProbe; i++)
			this->punctajProba[i] = punctajProba[i];
	}

	//getter pentru numeProba
	const char* getNumeProba() {
		return numeProba;
	}

	//getter punctajProba
	float* getPunctajProba() {
		return this->punctajProba;
	}

};


int Probe::nrProbe = 1;

class Clasament {
	const int loc;	// locul 1,2,3 etc
	static int nrLocuri;
	char* titlu;	// gen locul 1 pentru cel mai bun...
	float* punctajTotal;
	string numeArbitru;

	//CONSTRUCTOR FARA PARAMETRI
public:
	Clasament() :loc(nrLocuri++) {
		this->titlu = NULL;
		this->punctajTotal = NULL;
		cout << "S-a apelat constructorul FARA parametri CLASAMENT!" << endl;
	}

	//CONSTRUCTOR CU 1 PARAMETRU
	Clasament(char* titlu) :loc(nrLocuri++) {
		this->titlu = new char[strlen(titlu) + 1];
		strcpy(this->titlu, titlu);
		this->punctajTotal = NULL;
		cout << "S-a apelat constructorul cu 1 parametru CLASAMENT!" << endl;
	}

	//CONSTRUCTOR CU TOTI PARAMETRII
	Clasament(char* titlu, float* punctajTotal) :loc(nrLocuri++) {
		this->titlu = new char[strlen(titlu) + 1];
		strcpy(this->titlu, titlu);
		this->punctajTotal = new float[nrLocuri];
		for (int i = 0; i < nrLocuri; i++) {
			this->punctajTotal[i] = punctajTotal[i];
		}
		cout << "S-a apelat constructorul cu TOTI parametrii CLASAMENT!" << endl;
	}

	//DESTRUCTOR
	~Clasament() {
		if (this->titlu != NULL)
			delete[]this->titlu;
		if (this->punctajTotal != NULL)
			delete[]this->punctajTotal;
		cout << "S-a apelat destructor CLASAMENT!" << endl;
	}

	//setter titlu
	void setTitlu(char* titlu, int nrLocuriNou) {
		if (this->titlu != NULL) {
			delete[] this->titlu;
		}
		this->nrLocuri = nrLocuriNou;
		this->titlu = new char[this->nrLocuri];
		for (int i = 0; i < this->nrLocuri; i++) {
			this->titlu[i] = titlu[i];
		}
	}

	//setter punctajTotal
	void setPunctajTotal(float* punctajTotal, int nrLocuriNou) {
		this->nrLocuri = nrLocuriNou;
		if (this->punctajTotal != NULL)
			delete[]this->punctajTotal;
		this->punctajTotal = new float[nrLocuri];
		for (int i = 0; i < nrLocuri; i++)
			this->punctajTotal[i] = punctajTotal[i];
	}

	//getter pentru titlu
	const char* getTitlu() {
		return titlu;
	}

	//getter punctajTotal
	float* getPunctajTotal() {
		return this->punctajTotal;
	}
};

int Clasament::nrLocuri = 1;

int main() {

	//CLASA PARTICIPANT
	//apelare costructor fara parametrii
	Participant p1;
	//apelare funct varsta

	int varsta = 0;
	cout << "Introduceti varsta: " << endl;
	cin >> varsta;
	p1.setVarsta(varsta);
	cout << p1.getVarsta() << endl;

	char* nume = new char[10];
	cout << "Introduceti, ba, NUMELE: " << endl;
	cin >> nume;
	p1.setNume(nume);

	//apelare costructor cu 1 parametru
	Participant p2(25);
	cout << p2.getVarsta() << endl;

	//apelare costructor cu toti parametrii
	char numeP[] = { "Numele participantului este Ion." };
	float inaltime[] = { 1.2 };
	Participant p3(numeP, inaltime, 21);

	//apel constructor copiere
	Participant p4 = p3;

	//apel op >>
	cin >> p4;
	cout << p4;

	//apel functie de afisare 1
	p2.afisare();
	cout << "Prima afisare." << endl << endl << endl;

	//apel operator =
	p2 = p3;
	cout << "A doua afisare." << endl << endl << endl;

	//apel functie de afisare 2
	p2.afisare();


	/*
	- cod redundant, nu aveam nevoie sa le afisez mereu pe toate, cred ca o faceam doar pentru siguranta, dar ele nu erau necesare
	- peste tot sunt foarte multe comentarii cu "ce face urmatorul cod" sau "apelare x", dar se intelegea foarte usor si din cod
	*/



	//apel setter nume
	//p3.setNume(nume, strlen(nume) + 1);
	//apel getter nume
	cout << p3.getNume() << endl;
	//apel setter inaltime
	p3.setInaltime(inaltime, sizeof(inaltime) + 1);
	//apel getter inaltime
	float* inaltimeNoua = { p3.getInaltime() };
	cout << *inaltimeNoua << endl;

	//apelare INDEX []
	cout << "Participantul de pe prima pozitie: " << endl;
	try {
		cout << p1[4] << endl;
	}
	catch (exception* e) {
		cout << "Prima exceptie a fost prinsa. " << endl;
	}
	catch (...) {
		cout << "A doua exceptie a fost prinsa. " << endl;
	}

	//apel operator CAST;
	cout << "Inaltimea lui p1 este " << (float)p1 << endl; //afisam inaltimea pt participantul din obiectul p1
	cout << "S-a apelat operatorul CAST" << endl;

	//apel operator +
	p1 = p1 + 5;
	cout << p1.getVarsta() << endl;

	//apel operator -
	p2 = p2 - 5;
	cout << p2.getVarsta() << endl;

	//apel operator ==
	if (p4 == p3)
		cout << "p4==p3" << endl;
	else
		cout << "p4!=p3" << endl;

	//apel operator >=
	if ( p4>= p3)
		cout << "Adevarat" << endl;
	else
		cout << "Fals" << endl;

	//test supraincarcare preincrementare 
	Participant p9;
	p9 = ++p9;
	cout << "\n\nParticipantul cu numele " << p9.getNume() << " are " << p9.getVarsta() << " varsta." << endl;

	//test supraincarcare postincrementare 
	p9 = p9++;
	cout << "\n\nParticipantul cu numele " << p9.getNume() << " are " << p9.getVarsta() << " varsta." << endl;


	//apel operator !
	if (!p2)
		cout << "Adevarat" << endl;
	else
		cout << "Fals" << endl;

	//-----------------------------------------------------------------------------------
	//CLASA PROBE
	//apelare costructor fara parametrii
	Probe pr1;

	//apelare costructor cu 1 parametru
	char numeProba[] = { "Numele probei este: Paralele." };
	float punctajProba[] = { 9 };
	Probe pr2(numeProba);

	//apelare constructor cu toti parametrii
	Probe pr3(numeProba, punctajProba);

	//apel setter numeProba
	pr3.setNumeProba(numeProba, strlen(numeProba) + 1);
	//apel getter numeProba
	cout << pr3.getNumeProba() << endl;
	//apel setter punctajProba
	pr3.setPunctajProba(punctajProba, sizeof(punctajProba) + 1);
	//apel getter punctajProba
	float* punctajProbaNou = { pr3.getPunctajProba() };
	cout << *punctajProbaNou << endl;

	//----------------------------------------------------------------------------------------
	//CLASA CLASAMENT
	//apelare costructor fara parametri
	Clasament c1;

	//apelare costructor cu 1 parametru
	char titlu[] = { "Titlul obtinut de participant este: Locul 1." };
	float punctajTotal[] = { 37 };
	Clasament c2(titlu);

	//apelare costructor cu toti parametrii
	Clasament c3(titlu, punctajTotal);

	//apel setter titlu
	c3.setTitlu(titlu, strlen(titlu) + 1);
	//apel getter titlu
	cout << c3.getTitlu() << endl;
	//apel setter punctajTotal
	c3.setPunctajTotal(punctajTotal, sizeof(punctajTotal) + 1);
	//apel getter punctajTotal
	float* punctajTotalNou = { c3.getPunctajTotal() };
	cout << *punctajTotalNou << endl;

	return 0;

}