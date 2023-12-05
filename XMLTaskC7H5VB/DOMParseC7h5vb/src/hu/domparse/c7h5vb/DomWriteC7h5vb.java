package hu.domparse.c7h5vb;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DomWriteC7h5vb {

	public static void main(String[] args) {
		try {
			// XML fájl betöltése és Document objektum létrehozása
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new File("XMLC7H5VB.xml"));
			doc.getDocumentElement().normalize();

			// Új XML dokumentum létrehozása
			Document newDoc = dBuilder.newDocument();

			// Gyökérelem (C7H5VB_Hell) hozzáadása az új dokumentumhoz
			Element rootElement = newDoc.createElement("C7H5VB_Hell");
			newDoc.appendChild(rootElement);

			Comment gyarakComment = newDoc.createComment("Gyárak");
			rootElement.appendChild(gyarakComment);

			// Gyarak elemek létrehozása és hozzáadása
			Element gyarakElement1 = newDoc.createElement("Gyarak");
			gyarakElement1.setAttribute("GyarAzonosito", "1");
			gyarakElement1.setAttribute("VallalatiAzonosito", "1");
			// Cime elem és alárendelt elemei
			Element cimeElement1 = newDoc.createElement("Cime");
			Element utcaHazszamElement1 = newDoc.createElement("UtcaHazszam");
			utcaHazszamElement1.setTextContent("Vas utca 7");
			Element irSzamElement1 = newDoc.createElement("IrSzam");
			irSzamElement1.setTextContent("3534");
			Element varosElement1 = newDoc.createElement("Varos");
			varosElement1.setTextContent("Miskolc");
			cimeElement1.appendChild(utcaHazszamElement1);
			cimeElement1.appendChild(irSzamElement1);
			cimeElement1.appendChild(varosElement1);
			// GyartasiRata és Kiadasok elemek
			Element gyartasiRataElement1 = newDoc.createElement("GyartasiRata");
			gyartasiRataElement1.setTextContent("10000");
			Element kiadasokElement1 = newDoc.createElement("Kiadasok");
			kiadasokElement1.setTextContent("10000000");
			gyarakElement1.appendChild(cimeElement1);
			gyarakElement1.appendChild(gyartasiRataElement1);
			gyarakElement1.appendChild(kiadasokElement1);
			rootElement.appendChild(gyarakElement1);

			// Második Gyarak elem létrehozása és hozzáadása
			Element gyarakElement2 = newDoc.createElement("Gyarak");
			gyarakElement2.setAttribute("GyarAzonosito", "2");
			gyarakElement2.setAttribute("VallalatiAzonosito", "2");

			Element cimeElement2 = newDoc.createElement("Cime");
			Element utcaHazszamElement2 = newDoc.createElement("UtcaHazszam");
			utcaHazszamElement2.setTextContent("Gyár utca 1");
			Element irSzamElement2 = newDoc.createElement("IrSzam");
			irSzamElement2.setTextContent("3525");
			Element varosElement2 = newDoc.createElement("Varos");
			varosElement2.setTextContent("Miskolc");

			cimeElement2.appendChild(utcaHazszamElement2);
			cimeElement2.appendChild(irSzamElement2);
			cimeElement2.appendChild(varosElement2);

			Element gyartasiRataElement2 = newDoc.createElement("GyartasiRata");
			gyartasiRataElement2.setTextContent("15000");
			Element kiadasokElement2 = newDoc.createElement("Kiadasok");
			kiadasokElement2.setTextContent("13000000");

			gyarakElement2.appendChild(cimeElement2);
			gyarakElement2.appendChild(gyartasiRataElement2);
			gyarakElement2.appendChild(kiadasokElement2);
			rootElement.appendChild(gyarakElement2);

			// Harmadik Gyarak elem létrehozása és hozzáadása
			Element gyarakElement3 = newDoc.createElement("Gyarak");
			gyarakElement3.setAttribute("GyarAzonosito", "3");
			gyarakElement3.setAttribute("VallalatiAzonosito", "3");

			Element cimeElement3 = newDoc.createElement("Cime");
			Element utcaHazszamElement3 = newDoc.createElement("UtcaHazszam");
			utcaHazszamElement3.setTextContent("Hell utca 1");
			Element irSzamElement3 = newDoc.createElement("IrSzam");
			irSzamElement3.setTextContent("2092");
			Element varosElement3 = newDoc.createElement("Varos");
			varosElement3.setTextContent("Budakeszi");

			cimeElement3.appendChild(utcaHazszamElement3);
			cimeElement3.appendChild(irSzamElement3);
			cimeElement3.appendChild(varosElement3);

			Element gyartasiRataElement3 = newDoc.createElement("GyartasiRata");
			gyartasiRataElement3.setTextContent("35000");
			Element kiadasokElement3 = newDoc.createElement("Kiadasok");
			kiadasokElement3.setTextContent("19500000");

			gyarakElement3.appendChild(cimeElement3);
			gyarakElement3.appendChild(gyartasiRataElement3);
			gyarakElement3.appendChild(kiadasokElement3);
			rootElement.appendChild(gyarakElement3);

			Comment termekekComment = newDoc.createComment("Termékek");
			rootElement.appendChild(termekekComment);
			// Termekek elemek létrehozása és hozzáadása
			Element termekekElement1 = newDoc.createElement("Termekek");
			termekekElement1.setAttribute("VallalatiAzonosito", "1");
			Element fajtajaElement1 = newDoc.createElement("Fajtaja");
			Element xixoElement1 = newDoc.createElement("Xixo");
			xixoElement1.setTextContent("1");
			fajtajaElement1.appendChild(xixoElement1);
			Element bevetelElement1 = newDoc.createElement("Bevetel");
			bevetelElement1.setTextContent("50000000");
			Element kiadasokTermekekElement1 = newDoc.createElement("Kiadasok");
			Element marketingElement1 = newDoc.createElement("Marketing");
			marketingElement1.setTextContent("1200000");
			Element otletekElement1 = newDoc.createElement("Otletek");
			otletekElement1.setTextContent("1000000");
			Element tesztelesElement1 = newDoc.createElement("Teszteles");
			tesztelesElement1.setTextContent("500000");
			kiadasokTermekekElement1.appendChild(marketingElement1);
			kiadasokTermekekElement1.appendChild(otletekElement1);
			kiadasokTermekekElement1.appendChild(tesztelesElement1);
			kiadasokTermekekElement1.appendChild(fajtajaElement1);
			kiadasokTermekekElement1.appendChild(bevetelElement1);
			termekekElement1.appendChild(kiadasokTermekekElement1);
			rootElement.appendChild(termekekElement1);

			Element termekekElement2 = newDoc.createElement("Termekek");
			termekekElement2.setAttribute("VallalatiAzonosito", "2");
			Element fajtajaElement2 = newDoc.createElement("Fajtaja");
			Element hellElement2 = newDoc.createElement("Hell");
			hellElement2.setTextContent("1");
			fajtajaElement2.appendChild(hellElement2);
			Element bevetelElement2 = newDoc.createElement("Bevetel");
			bevetelElement2.setTextContent("80000000");
			Element kiadasokTermekekElement2 = newDoc.createElement("Kiadasok");
			Element marketingElement2 = newDoc.createElement("Marketing");
			marketingElement2.setTextContent("3200000");
			Element otletekElement2 = newDoc.createElement("Otletek");
			otletekElement2.setTextContent("1200000");
			Element tesztelesElement2 = newDoc.createElement("Teszteles");
			tesztelesElement2.setTextContent("700000");
			kiadasokTermekekElement2.appendChild(marketingElement2);
			kiadasokTermekekElement2.appendChild(otletekElement2);
			kiadasokTermekekElement2.appendChild(tesztelesElement2);
			termekekElement2.appendChild(fajtajaElement2);
			termekekElement2.appendChild(bevetelElement2);
			termekekElement2.appendChild(kiadasokTermekekElement2);
			rootElement.appendChild(termekekElement2);

			// Termekek elemek létrehozása és hozzáadása a harmadik termékhez
			Element termekekElement3 = newDoc.createElement("Termekek");
			termekekElement3.setAttribute("VallalatiAzonosito", "3");
			Element fajtajaElement3 = newDoc.createElement("Fajtaja");
			Element egyebElement3 = newDoc.createElement("Egyeb");
			egyebElement3.setTextContent("1");
			fajtajaElement3.appendChild(egyebElement3);
			Element bevetelElement3 = newDoc.createElement("Bevetel");
			bevetelElement3.setTextContent("7000000");
			Element kiadasokTermekekElement3 = newDoc.createElement("Kiadasok");
			Element marketingElement3 = newDoc.createElement("Marketing");
			marketingElement3.setTextContent("700000");
			Element otletekElement3 = newDoc.createElement("Otletek");
			otletekElement3.setTextContent("250000");
			Element tesztelesElement3 = newDoc.createElement("Teszteles");
			tesztelesElement3.setTextContent("150000");
			kiadasokTermekekElement3.appendChild(marketingElement3);
			kiadasokTermekekElement3.appendChild(otletekElement3);
			kiadasokTermekekElement3.appendChild(tesztelesElement3);
			termekekElement3.appendChild(fajtajaElement3);
			termekekElement3.appendChild(bevetelElement3);
			termekekElement3.appendChild(kiadasokTermekekElement3);
			rootElement.appendChild(termekekElement3);

			Comment dolgozokComment = newDoc.createComment("Dolgozók");
			rootElement.appendChild(dolgozokComment);
			// Dolgozok elemek létrehozása és hozzáadása
			Element dolgozokElement1 = newDoc.createElement("Dolgozok");
			dolgozokElement1.setAttribute("ID", "1");
			dolgozokElement1.setAttribute("GyarAzonosito", "1");
			Element lakcimElement1 = newDoc.createElement("Lakcim");
			Element utcaHazszamElementD1 = newDoc.createElement("UtcaHazszam");
			utcaHazszamElementD1.setTextContent("Kerek utca 7");
			Element irSzamElementD1 = newDoc.createElement("IrSzam");
			irSzamElementD1.setTextContent("3533");
			Element varosElementD1 = newDoc.createElement("Varos");
			varosElementD1.setTextContent("Miskolc");
			lakcimElement1.appendChild(utcaHazszamElementD1);
			lakcimElement1.appendChild(irSzamElementD1);
			lakcimElement1.appendChild(varosElementD1);
			Element beosztasElement1 = newDoc.createElement("Beosztas");
			beosztasElement1.setTextContent("Gyártósoros");
			Element nevElement1 = newDoc.createElement("Nev");
			nevElement1.setTextContent("Nagy Ernő");
			Element fizetesElement1 = newDoc.createElement("Fizetes");
			fizetesElement1.setTextContent("250000");
			Element telefonszamElement1 = newDoc.createElement("Telefonszam");
			telefonszamElement1.setTextContent("06307687647");
			dolgozokElement1.appendChild(lakcimElement1);
			dolgozokElement1.appendChild(beosztasElement1);
			dolgozokElement1.appendChild(nevElement1);
			dolgozokElement1.appendChild(fizetesElement1);
			dolgozokElement1.appendChild(telefonszamElement1);
			rootElement.appendChild(dolgozokElement1);
			// Dolgozok elemek létrehozása és hozzáadása a második dolgozóhoz
			Element dolgozokElement2 = newDoc.createElement("Dolgozok");
			dolgozokElement2.setAttribute("ID", "2");
			dolgozokElement2.setAttribute("GyarAzonosito", "3");
			Element lakcimElement2 = newDoc.createElement("Lakcim");
			Element utcaHazszamElementD2 = newDoc.createElement("UtcaHazszam");
			utcaHazszamElementD2.setTextContent("Kis utca 23");
			Element irSzamElementD2 = newDoc.createElement("IrSzam");
			irSzamElementD2.setTextContent("3523");
			Element varosElementD2 = newDoc.createElement("Varos");
			varosElementD2.setTextContent("Miskolc");
			lakcimElement2.appendChild(utcaHazszamElementD2);
			lakcimElement2.appendChild(irSzamElementD2);
			lakcimElement2.appendChild(varosElementD2);
			Element beosztasElement2 = newDoc.createElement("Beosztas");
			beosztasElement2.setTextContent("Gyártósoros");
			Element nevElement2 = newDoc.createElement("Nev");
			nevElement2.setTextContent("Látó Lajos");
			Element fizetesElement2 = newDoc.createElement("Fizetes");
			fizetesElement2.setTextContent("245000");
			Element telefonszamElement2 = newDoc.createElement("Telefonszam");
			telefonszamElement2.setTextContent("06307661589");
			dolgozokElement2.appendChild(lakcimElement2);
			dolgozokElement2.appendChild(beosztasElement2);
			dolgozokElement2.appendChild(nevElement2);
			dolgozokElement2.appendChild(fizetesElement2);
			dolgozokElement2.appendChild(telefonszamElement2);
			rootElement.appendChild(dolgozokElement2);

			// Dolgozok elemek létrehozása és hozzáadása a harmadik dolgozóhoz
			Element dolgozokElement3 = newDoc.createElement("Dolgozok");
			dolgozokElement3.setAttribute("ID", "3");
			dolgozokElement3.setAttribute("GyarAzonosito", "2");
			Element lakcimElement3 = newDoc.createElement("Lakcim");
			Element utcaHazszamElementD3 = newDoc.createElement("UtcaHazszam");
			utcaHazszamElementD3.setTextContent("Mester utca 2");
			Element irSzamElementD3 = newDoc.createElement("IrSzam");
			irSzamElementD3.setTextContent("2092");
			Element varosElementD3 = newDoc.createElement("Varos");
			varosElementD3.setTextContent("Budakeszi");
			lakcimElement3.appendChild(utcaHazszamElementD3);
			lakcimElement3.appendChild(irSzamElementD3);
			lakcimElement3.appendChild(varosElementD3);
			Element beosztasElement3 = newDoc.createElement("Beosztas");
			beosztasElement3.setTextContent("Takarító");
			Element nevElement3 = newDoc.createElement("Nev");
			nevElement3.setTextContent("Hangos Ernő");
			Element fizetesElement3 = newDoc.createElement("Fizetes");
			fizetesElement3.setTextContent("220000");
			Element telefonszamElement3 = newDoc.createElement("Telefonszam");
			telefonszamElement3.setTextContent("062096758956");
			dolgozokElement3.appendChild(lakcimElement3);
			dolgozokElement3.appendChild(beosztasElement3);
			dolgozokElement3.appendChild(nevElement3);
			dolgozokElement3.appendChild(fizetesElement3);
			dolgozokElement3.appendChild(telefonszamElement3);
			rootElement.appendChild(dolgozokElement3);

			Comment avalonComment = newDoc.createComment("Avalon Park");
			rootElement.appendChild(avalonComment);
			// AvalonPark elem létrehozása és hozzáadása
			Element avalonParkElement = newDoc.createElement("AvalonPark");
			avalonParkElement.setAttribute("Azonosito", "1");
			avalonParkElement.setAttribute("VezID", "1");

			// AvalonPark Kiadasok és Bevetel elemek
			Element avalonParkKiadasok = newDoc.createElement("Kiadasok");
			Element avalonParkMarketing = newDoc.createElement("Marketing");
			avalonParkMarketing.setTextContent("1000000");
			Element avalonParkKarbantartas = newDoc.createElement("Karbantartas");
			avalonParkKarbantartas.setTextContent("2500000");
			Element avalonParkMerchandiseok = newDoc.createElement("Merchandiseok");
			avalonParkMerchandiseok.setTextContent("3300000");
			Element avalonParkEgyeb = newDoc.createElement("Egyeb");
			avalonParkEgyeb.setTextContent("3000000");
			avalonParkKiadasok.appendChild(avalonParkMarketing);
			avalonParkKiadasok.appendChild(avalonParkKarbantartas);
			avalonParkKiadasok.appendChild(avalonParkMerchandiseok);
			avalonParkKiadasok.appendChild(avalonParkEgyeb);

			Element avalonParkBevetel = newDoc.createElement("Bevetel");
			avalonParkBevetel.setTextContent("60000000");

			Element avalonParkCime = newDoc.createElement("Cime");
			avalonParkCime.setTextContent("Miskolc Iglói u. 15, 3519");

			avalonParkElement.appendChild(avalonParkKiadasok);
			avalonParkElement.appendChild(avalonParkBevetel);
			avalonParkElement.appendChild(avalonParkCime);
			rootElement.appendChild(avalonParkElement);

			Comment vezetoComment = newDoc.createComment("Vezető");
			rootElement.appendChild(vezetoComment);
			// Vezeto elem létrehozása és hozzáadása
			Element vezetoElement = newDoc.createElement("Vezeto");
			vezetoElement.setAttribute("VezID", "1");

			Element vezetoLakcim = newDoc.createElement("Lakcim");
			Element vezetoUtcaHazszam = newDoc.createElement("UtcaHazszam");
			vezetoUtcaHazszam.setTextContent("Leveles utca 12");
			Element vezetoIrSzam = newDoc.createElement("IrSzam");
			vezetoIrSzam.setTextContent("3520");
			Element vezetoVaros = newDoc.createElement("Varos");
			vezetoVaros.setTextContent("Miskolc");

			vezetoLakcim.appendChild(vezetoUtcaHazszam);
			vezetoLakcim.appendChild(vezetoIrSzam);
			vezetoLakcim.appendChild(vezetoVaros);

			Element vezetoNev = newDoc.createElement("Nev");
			vezetoNev.setTextContent("Lázár Ervin");

			vezetoElement.appendChild(vezetoLakcim);
			vezetoElement.appendChild(vezetoNev);
			rootElement.appendChild(vezetoElement);

			Comment kiszallitasComment = newDoc.createComment("Kiszállítás");
			rootElement.appendChild(kiszallitasComment);
			// Kiszallitas elemek létrehozása és hozzáadása
			Element kiszallitasElement1 = newDoc.createElement("Kiszallitas");
			kiszallitasElement1.setAttribute("GyarAzonosito", "1");
			kiszallitasElement1.setAttribute("MegrendeloAzonosito", "1");
			Element kiszallitasMennyiseg1 = newDoc.createElement("Mennyiseg");
			kiszallitasMennyiseg1.setTextContent("2500");
			kiszallitasElement1.appendChild(kiszallitasMennyiseg1);
			rootElement.appendChild(kiszallitasElement1);

			Element kiszallitasElement2 = newDoc.createElement("Kiszallitas");
			kiszallitasElement2.setAttribute("GyarAzonosito", "2");
			kiszallitasElement2.setAttribute("MegrendeloAzonosito", "2");
			Element kiszallitasMennyiseg2 = newDoc.createElement("Mennyiseg");
			kiszallitasMennyiseg2.setTextContent("5000");
			kiszallitasElement2.appendChild(kiszallitasMennyiseg2);
			rootElement.appendChild(kiszallitasElement2);

			Element kiszallitasElement3 = newDoc.createElement("Kiszallitas");
			kiszallitasElement3.setAttribute("GyarAzonosito", "3");
			kiszallitasElement3.setAttribute("MegrendeloAzonosito", "3");
			Element kiszallitasMennyiseg3 = newDoc.createElement("Mennyiseg");
			kiszallitasMennyiseg3.setTextContent("1200");
			kiszallitasElement3.appendChild(kiszallitasMennyiseg3);
			rootElement.appendChild(kiszallitasElement3);

			Comment megrendelokComment = newDoc.createComment("Megrendelők");
			rootElement.appendChild(megrendelokComment);
			// Megrendelok elemek létrehozása és hozzáadása
			Element megrendelokElement1 = newDoc.createElement("Megrendelok");
			megrendelokElement1.setAttribute("MegrendeloAzonosito", "1");
			Element megrendelokElerhetoseg1 = newDoc.createElement("Elerhetoseg");
			Element megrendelokEmail1 = newDoc.createElement("Email");
			megrendelokEmail1.setTextContent("ugyfelszolgalat@coop.hu");
			Element megrendelokTelefonSzam1 = newDoc.createElement("TelefonSzam");
			megrendelokTelefonSzam1.setTextContent("06307658799");
			megrendelokElerhetoseg1.appendChild(megrendelokEmail1);
			megrendelokElerhetoseg1.appendChild(megrendelokTelefonSzam1);

			Element megrendelokCime1 = newDoc.createElement("Cime");
			Element megrendelokUtcaHazszam1 = newDoc.createElement("UtcaHazszam");
			megrendelokUtcaHazszam1.setTextContent("Corvin utca 7");
			Element megrendelokIrSzam1 = newDoc.createElement("IrSzam");
			megrendelokIrSzam1.setTextContent("3525");
			Element megrendelokVaros1 = newDoc.createElement("Varos");
			megrendelokVaros1.setTextContent("Miskolc");

			megrendelokCime1.appendChild(megrendelokUtcaHazszam1);
			megrendelokCime1.appendChild(megrendelokIrSzam1);
			megrendelokCime1.appendChild(megrendelokVaros1);

			megrendelokElement1.appendChild(megrendelokElerhetoseg1);
			megrendelokElement1.appendChild(megrendelokCime1);
			rootElement.appendChild(megrendelokElement1);

			// További Megrendelok elemek létrehozása és hozzáadása
			Element megrendelokElement2 = newDoc.createElement("Megrendelok");
			megrendelokElement2.setAttribute("MegrendeloAzonosito", "2");

			Element megrendelokElerhetoseg2 = newDoc.createElement("Elerhetoseg");
			Element megrendelokEmail2 = newDoc.createElement("Email");
			megrendelokEmail2.setTextContent("beszerzes@spar.hu");
			Element megrendelokTelefonSzam2 = newDoc.createElement("TelefonSzam");
			megrendelokTelefonSzam2.setTextContent("06407658788");
			megrendelokElerhetoseg2.appendChild(megrendelokEmail2);
			megrendelokElerhetoseg2.appendChild(megrendelokTelefonSzam2);

			Element megrendelokCime2 = newDoc.createElement("Cime");
			Element megrendelokUtcaHazszam2 = newDoc.createElement("UtcaHazszam");
			megrendelokUtcaHazszam2.setTextContent("Magas út 26");
			Element megrendelokIrSzam2 = newDoc.createElement("IrSzam");
			megrendelokIrSzam2.setTextContent("3533");
			Element megrendelokVaros2 = newDoc.createElement("Varos");
			megrendelokVaros2.setTextContent("Miskolc");

			megrendelokCime2.appendChild(megrendelokUtcaHazszam2);
			megrendelokCime2.appendChild(megrendelokIrSzam2);
			megrendelokCime2.appendChild(megrendelokVaros2);

			megrendelokElement2.appendChild(megrendelokElerhetoseg2);
			megrendelokElement2.appendChild(megrendelokCime2);
			rootElement.appendChild(megrendelokElement2);

			Element megrendelokElement3 = newDoc.createElement("Megrendelok");
			megrendelokElement3.setAttribute("MegrendeloAzonosito", "3");

			Element megrendelokElerhetoseg3 = newDoc.createElement("Elerhetoseg");
			Element megrendelokEmail3 = newDoc.createElement("Email");
			megrendelokEmail3.setTextContent("megrendelo@arena.hu");
			Element megrendelokTelefonSzam3 = newDoc.createElement("TelefonSzam");
			megrendelokTelefonSzam3.setTextContent("06105758595");
			megrendelokElerhetoseg3.appendChild(megrendelokEmail3);
			megrendelokElerhetoseg3.appendChild(megrendelokTelefonSzam3);

			Element megrendelokCime3 = newDoc.createElement("Cime");
			Element megrendelokUtcaHazszam3 = newDoc.createElement("UtcaHazszam");
			megrendelokUtcaHazszam3.setTextContent("Kerepesi út 9");
			Element megrendelokIrSzam3 = newDoc.createElement("IrSzam");
			megrendelokIrSzam3.setTextContent("1087");
			Element megrendelokVaros3 = newDoc.createElement("Varos");
			megrendelokVaros3.setTextContent("Budapest");

			megrendelokCime3.appendChild(megrendelokUtcaHazszam3);
			megrendelokCime3.appendChild(megrendelokIrSzam3);
			megrendelokCime3.appendChild(megrendelokVaros3);

			megrendelokElement3.appendChild(megrendelokElerhetoseg3);
			megrendelokElement3.appendChild(megrendelokCime3);
			rootElement.appendChild(megrendelokElement3);

			// Az új XML fájl mentése
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(newDoc);
			StreamResult result = new StreamResult(new File("XMLC7H5VB1.xml"));
			transformer.transform(source, result);

			System.out.println("Az új XML fájl létrehozása sikeres!");
			System.out.println("");
			// Konzolra írás
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);
			


			// Exception kezelése
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
