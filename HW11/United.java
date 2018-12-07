public class United extends Graph {
  United() {
      Vertex van = new Vertex("vancouver");  
          Vertex cal = new Vertex("calgary");  
          Vertex win = new Vertex("winnipeg");  
          Vertex ssm = new Vertex("sault ste. marie");  
          Vertex bos = new Vertex("boston");  
          Vertex mon = new Vertex("montreal");  
          Vertex ny = new Vertex("new york");  
          Vertex tor = new Vertex("toronto");  
          Vertex pit = new Vertex("pittsburgh");  
          Vertex was = new Vertex("washington");  
          Vertex ral = new Vertex("raleigh");  
          Vertex cha = new Vertex("charleston");  
          Vertex mia = new Vertex("miami");  
          Vertex atl = new Vertex("atlanta");  
          Vertex nas = new Vertex("nashville");  
          Vertex chi = new Vertex("chicago");  
          Vertex sl = new Vertex("saint louis");  
          Vertex lr = new Vertex("little rock");  
          Vertex no = new Vertex("new orleans");  
          Vertex hou = new Vertex("houston");  
          Vertex dal = new Vertex("dallas");  
          Vertex oc = new Vertex("oklahoma city");  
          Vertex kc = new Vertex("kansas city");  
          Vertex oma = new Vertex("omaha");  
          Vertex dul = new Vertex("duluth");  
          Vertex hel = new Vertex("helena");  
          Vertex slc = new Vertex("salt lake city");  
          Vertex den = new Vertex("denver");  
          Vertex sfe = new Vertex("santa fe");  
          Vertex ep = new Vertex("el paso");  
          Vertex pho = new Vertex("phoenix");  
          Vertex lv = new Vertex("las vegas");  
          Vertex sf = new Vertex("san francisco");  
          Vertex la = new Vertex("los angeles");  
          Vertex por = new Vertex("portland");  
          Vertex sea = new Vertex("seattle");  
            
          this.put( van, new Neighbors(new Vertex[] {   cal,  sea} ));  
          this.put( cal, new Neighbors(new Vertex[] {  van, sea, hel, win  } ));  
          this.put( win, new Neighbors(new Vertex[] { cal,  hel, dul,  ssm } ));  
          this.put( ssm, new Neighbors(new Vertex[] {   win,  dul,  tor,  mon  } ));  
          this.put( mon, new Neighbors(new Vertex[] {  bos,  ny,  tor,  ssm } ));  
          this.put( bos, new Neighbors(new Vertex[] {  mon,  ny} ));  
          this.put( ny, new Neighbors(new Vertex[] {  was,  pit,  mon,  bos } ));  
          this.put( tor, new Neighbors(new Vertex[] {ssm,  mon,  pit,  dul,  chi } ));  
          this.put( pit, new Neighbors(new Vertex[] {  tor,  ny,  was,  ral,  nas,  sl,  chi } ));  
          this.put( was, new Neighbors(new Vertex[] {  ny,  pit,  ral  } ));  
          this.put( ral, new Neighbors(new Vertex[] { cha,  atl,  nas,  pit,  was  } ));  
          this.put( cha, new Neighbors(new Vertex[] { ral,  atl,  mia } ));  
          this.put( mia, new Neighbors(new Vertex[] { cha,  atl,  no  } ));  
          this.put( atl, new Neighbors(new Vertex[] { ral,  cha,  mia,  no,  nas  } ));  
          this.put( nas, new Neighbors(new Vertex[] {  sl,  lr,  atl,  ral,  pit  } ));  
          this.put( chi, new Neighbors(new Vertex[] { pit,  sl,  tor,  dul,  oma  } ));  
          this.put( sl, new Neighbors(new Vertex[] { chi,  pit,  nas,  lr,  kc  } ));  
          this.put( lr, new Neighbors(new Vertex[] { nas,  no,  dal,  oc,  sl } ));  
          this.put( no, new Neighbors(new Vertex[] { hou,  lr,  atl,  mia } ));  
          this.put( hou, new Neighbors(new Vertex[] { ep,  dal,  no  } ));  
          this.put( dal, new Neighbors(new Vertex[] { lr,  hou,  ep,  oc  } ));  
          this.put( oc, new Neighbors(new Vertex[] { den,  kc,  lr,  dal,  ep,  sfe } ));  
          this.put( kc, new Neighbors(new Vertex[] { oma,  sl,  oc,  den  } ));  
          this.put( oma, new Neighbors(new Vertex[] { hel, dul,  chi,  kc,  den } ));  
          this.put( dul, new Neighbors(new Vertex[] { win,  ssm,   tor,  chi,  oma,  hel } ));  
          this.put( hel, new Neighbors(new Vertex[] { sea, cal,  win,  dul,  oma,  den,  slc  } ));  
          this.put( slc, new Neighbors(new Vertex[] { por,  hel, den,  sf,  sf } ));  
          this.put( den, new Neighbors(new Vertex[] { slc,  hel, oma,  kc,  oc,  sfe,  pho  } ));  
          this.put( sfe, new Neighbors(new Vertex[] { den,  oc,  ep,  pho  } ));  
          this.put( ep, new Neighbors(new Vertex[] { la,  pho,  sfe,  oc,  dal,  hou } ));  
          this.put( pho, new Neighbors(new Vertex[] {la,  den,  sfe,  ep } ));  
          this.put( lv, new Neighbors(new Vertex[] { slc,  la  } ));  
          this.put( sf, new Neighbors(new Vertex[] {  por,  slc,  la } ));  
          this.put( la, new Neighbors(new Vertex[] {  sf,  sf,  pho,  ep } ));  
          this.put( por, new Neighbors(new Vertex[] { sea, slc,  sf } ));  
          this.put( sea, new Neighbors(new Vertex[] {  van, cal,  hel, por } )); 

  }
  public static void main(String[] args) {
    Graph a = new United(); 
    System.out.println( a + "\n---" );
    a.show(); 
    Vertex sf = new Vertex("san francisco"); 
    System.out.println( a.get(sf) ); 
    System.out.println( "true? " + a.containsKey(sf) ); // should be true
  }
}