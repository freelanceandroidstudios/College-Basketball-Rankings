package com.menscollegerankings.main;

import java.io.IOException;
import java.io.StringReader;
import java.util.Collections;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xmlpull.v1.XmlPullParserException;

/*
 * EXAMPLE OF DATA RECEIEVED
 * 
 * <?xml version="1.0" encoding="UTF-8"?>
 <?xml-stylesheet type="text/xsl" charset="UTF-8" href="/xslt/basketball/ncaam/ranking-v2.0.xsl"?>
 <!-- Generation started @ 2014-12-15 18:11:53 +0000 -->
 <poll xmlns="http://feed.elasticstats.com/schema/basketball/ranking-v2.0.xsd" id="9341408d-9f9a-463f-ab60-be8d1aeeffa2" alias="AP" name="AP Top 25" year="2014" week="W6" effective_time="2014-12-15T17:30:00+00:00">
 <rankings>
 <team id="0d037a5d-827a-44dd-8b70-57603d671d5d" name="Utes" market="Utah" rank="14" wins="7" losses="2" prev_rank="13" points="670"/>
 <team id="0e4258fa-3154-4c16-b693-adecab184c6c" name="Cyclones" market="Iowa State" rank="13" wins="8" losses="1" prev_rank="14" points="772"/>
 <team id="2267a1f4-68f6-418b-aaf6-2aa0c4b291f1" name="Wildcats" market="Kentucky" rank="1" wins="11" losses="0" prev_rank="1" points="1625" fp_votes="65"/>
 <team id="2778d005-cc14-4e58-9bf2-3fc37bffb62f" name="Terrapins" market="Maryland" rank="17" wins="10" losses="1" prev_rank="19" points="512"/>
 <team id="2f4d21f8-6d5f-48a5-abca-52a30583871a" name="Bulldogs" market="Gonzaga" rank="8" wins="9" losses="1" prev_rank="9" points="1175"/>
 <team id="4383eb6a-7fd8-4ff2-94c5-43c933121e88" name="Wildcats" market="Villanova" rank="7" wins="10" losses="0" prev_rank="7" points="1215"/>
 <team id="56913910-87f7-4ad7-ae3b-5cd9fb218fd9" name="Cavaliers" market="Virginia" rank="6" wins="9" losses="0" prev_rank="6" points="1294"/>
 <team id="6ed15092-2670-450a-99c2-61d861e87644" name="Longhorns" market="Texas" rank="9" wins="8" losses="1" prev_rank="8" points="1154"/>
 <team id="7aec5187-cb1b-45e5-8f7d-406d766cdc73" name="Hurricanes" market="Miami (FL)" rank="18" wins="9" losses="1" prev_rank="20" points="426"/>
 <team id="80962f09-8821-48b6-8cf0-0cf0eea56aa8" name="Fighting Irish" market="Notre Dame" rank="21" wins="10" losses="1" prev_rank="25" points="351"/>
 <team id="857462b3-0ab6-4d26-9669-10ca354e382b" name="Buckeyes" market="Ohio State" rank="12" wins="8" losses="1" prev_rank="12" points="838"/>
 <team id="9b166a3f-e64b-4825-bb6b-92c6f0418263" name="Wildcats" market="Arizona" rank="3" wins="10" losses="0" prev_rank="3" points="1505"/>
 <team id="a41d5a05-4c11-4171-a57e-e7a1ea325a6d" name="Spartans" market="Michigan State" rank="25" wins="7" losses="3" points="116"/>
 <team id="b2fda957-e15c-4fb2-8a13-6e58496f561e" name="Sooners" market="Oklahoma" rank="15" wins="6" losses="2" prev_rank="16" points="647"/>
 <team id="b795ddbc-baab-4499-8803-52e8608520ab" name="Cardinals" market="Louisville" rank="4" wins="9" losses="0" prev_rank="4" points="1349"/>
 <team id="bdb7d7a4-45f8-4bf3-ab85-15488c451494" name="Bulldogs" market="Butler" rank="23" wins="8" losses="2" prev_rank="15" points="259"/>
 <team id="c1f4aae1-aa16-4095-aeab-10e5c2a1236a" name="Red Storm" market="St. John's" rank="20" wins="8" losses="1" prev_rank="24" points="353"/>
 <team id="c7569eae-5b93-4197-b204-6f3a62146b25" name="Badgers" market="Wisconsin" rank="5" wins="10" losses="1" prev_rank="5" points="1331"/>
 <team id="e52c9644-717a-46f4-bf16-aeca000b3b44" name="Huskies" market="Washington" rank="16" wins="8" losses="0" prev_rank="17" points="598"/>
 <team id="e6914f16-ca37-4d2e-ba26-a425910283e2" name="Aztecs" market="San Diego State" rank="19" wins="7" losses="2" prev_rank="18" points="424"/>
 <team id="e9ca48b2-00ba-41c0-a02b-6885a2da1ff1" name="Tar Heels" market="North Carolina" rank="24" wins="6" losses="3" prev_rank="21" points="122"/>
 <team id="f38b58de-3273-4723-a78b-2f918e9aa2d5" name="Shockers" market="Wichita State" rank="11" wins="7" losses="1" prev_rank="11" points="959"/>
 <team id="f770d3a2-221c-49ce-9c7a-680f7417fe9e" name="Mountaineers" market="West Virginia" rank="22" wins="9" losses="1" prev_rank="22" points="333"/>
 <team id="fae4855b-1b64-4b40-a632-9ed345e1e952" name="Jayhawks" market="Kansas" rank="10" wins="8" losses="1" prev_rank="10" points="1102"/>
 <team id="faeb1160-5d15-4f26-99fc-c441cf21fc7f" name="Blue Devils" market="Duke" rank="2" wins="8" losses="0" prev_rank="2" points="1545"/>
 </rankings>
 <candidates>
 <team id="1a470730-f328-4fb1-8bbf-36a069e4d6b2" name="Rams" market="Colorado State" wins="10" losses="0" votes="75"/>
 <team id="2920c5fa-1e86-4958-a7c4-1e97b8e201d8" name="Wildcats" market="Davidson" wins="8" losses="1" votes="1"/>
 <team id="2c93a75d-5449-4ec1-9ca2-1e6c812399a4" name="Panthers" market="Northern Iowa" wins="9" losses="1" prev_rank="23" votes="65"/>
 <team id="4aebd148-8119-4875-954c-66779867989b" name="Nittany Lions" market="Penn State" wins="10" losses="1" votes="3"/>
 <team id="70e2bedd-3a0a-479c-ac99-e3f58aa6824b" name="Tigers" market="LSU" wins="7" losses="2" votes="4"/>
 <team id="8736b67f-5924-400b-bf94-3bd804c36600" name="Hoyas" market="Georgetown" wins="6" losses="3" votes="41"/>
 <team id="8ab00d43-840a-4c96-bdee-bf88fa6e3f11" name="Cowboys" market="Oklahoma State" wins="8" losses="1" votes="4"/>
 <team id="aacdc78d-b7fa-48f6-9686-2fdb8a95030e" name="Golden Bears" market="California" wins="9" losses="1" votes="37"/>
 <team id="aef5e386-d8e8-460c-8014-3a2f090fd988" name="Pirates" market="Seton Hall" wins="8" losses="1" votes="14"/>
 <team id="c1c1e6df-a383-4fbd-ba7b-32d4f9ef9518" name="Rams" market="Virginia Commonwealth" wins="6" losses="3" votes="6"/>
 <team id="c70c23c4-ab09-4797-a1af-792c848ab17f" name="Razorbacks" market="Arkansas" wins="7" losses="2" votes="19"/>
 <team id="ce967953-5c50-4220-87b2-99acb9606e84" name="Monarchs" market="Old Dominion" wins="7" losses="1" votes="4"/>
 <team id="db6e1cab-3fa3-4a93-a673-8b2a358ff4bf" name="Bears" market="Baylor" wins="8" losses="1" votes="97"/>
 <team id="f7fcbb6e-4a55-41ea-ba21-f763ed914467" name="Horned Frogs" market="TCU" wins="10" losses="0" votes="80"/>
 </candidates>
 </poll>
 <!-- Generation ended @ 2014-12-15 18:11:53 +0000 -->

 END OF EXAMPLE DATA
 */

public class XMLParser {

	private final String TEAM_TAG = "team";
	private DataStorage dataStorage;
	private String data;

	public XMLParser(String data) {
		this.data = data;
		dataStorage = new DataStorage();

	}

	public void parseXMLRankings() throws XmlPullParserException, IOException {

		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(data));
			Document doc = dBuilder.parse(is);

			doc.getDocumentElement().normalize();

			System.out.println("Root element :"
					+ doc.getDocumentElement().getNodeName());

			dataStorage.setUpdatedTime(doc.getDocumentElement().getAttribute(
					"effective_time"));

			NodeList nList = doc.getElementsByTagName(TEAM_TAG);

			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Team team = new Team();
				NonRankedTeams nonRankedTeam;

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					if (eElement.getAttribute("rank").equals("")) {
						nonRankedTeam = new NonRankedTeams();

						nonRankedTeam.setName(eElement.getAttribute("market")
								+ " " + (eElement.getAttribute("name")));
						nonRankedTeam.setVotes(eElement.getAttribute("votes"));

						dataStorage.getConsideration().add(nonRankedTeam);
						continue;
					}

					team = new Team();

					team.setName(eElement.getAttribute("market") + " "
							+ eElement.getAttribute("name"));
					team.setRank(eElement.getAttribute("rank"));
					team.setWins(eElement.getAttribute("wins"));
					team.setLosses(eElement.getAttribute("losses"));
					team.setPreviousRank(eElement.getAttribute("prev_rank"));

					dataStorage.getTeams().add(team); // ad team to main
														// arraylist
				}

			}

			// sort all team objects by team name
			Collections.sort(dataStorage.getTeams(), new SortRankings());
			Collections.sort(dataStorage.getConsideration(),
					new SortNonRankedTeams());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @return the dataStorage
	 */
	public DataStorage getDataStorage() {
		return dataStorage;
	}
}
