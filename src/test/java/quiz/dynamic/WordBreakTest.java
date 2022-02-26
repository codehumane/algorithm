package quiz.dynamic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordBreakTest {

    private final WordBreak solution = new WordBreak();

    @ParameterizedTest
    @CsvSource(
            delimiter = '|',
            value = {
                    " leetcode       | leet,code             | true ",
                    " applepenapple  | apple,pen             | true",
                    " catsandog      | cats,dog,sand,and,cat | false"
            }
    )
    void example(String text, String words, boolean expected) {
        verify(text, words, expected);
    }

    @ParameterizedTest
    @CsvSource(
            delimiter = '|',
            value = {
                    " aabbb        | aa,a,abbb        | true  ",
                    " aaabbb       | a,aa,abbb        | true  ",
                    " aabbb        | aa,abbb          | false ",
                    " aabbb        | a,abbb           | true  ",
                    " aabbb        | a,abba           | false ",
                    " aaaa         | a,aa,aaa,aaaa    | true  ",
                    " aaa          | aaa              | true  ",
                    " aaa          | aaaa             | false ",
                    " aaa          | a                | true  ",
                    " aaab         | a,aa             | false ",
                    " fohhemkkaecojceoaejkkoedkofhmohkcjmkggcmnami | kfomka,hecagbngambii,anobmnikj,c,nnkmfelneemfgcl,ah,bgomgohl,lcbjbg,ebjfoiddndih,hjknoamjbfhckb,eioldlijmmla,nbekmcnakif,fgahmihodolmhbi,gnjfe,hk,b,jbfgm,ecojceoaejkkoed,cemodhmbcmgl,j,gdcnjj,kolaijoicbc,liibjjcini,lmbenj,eklingemgdjncaa,m,hkh,fblb,fk,nnfkfanaga,eldjml,iejn,gbmjfdooeeko,jafogijka,ngnfggojmhclkjd,bfagnfclg,imkeobcdidiifbm,ogeo,gicjog,cjnibenelm,ogoloc,edciifkaff,kbeeg,nebn,jdd,aeojhclmdn,dilbhl,dkk,bgmck,ohgkefkadonafg,labem,fheoglj,gkcanacfjfhogjc,eglkcddd,lelelihakeh,hhjijfiodfi,enehbibnhfjd,gkm,ggj,ag,hhhjogk,lllicdhihn,goakjjnk,lhbn,fhheedadamlnedh,bin,cl,ggjljjjf,fdcdaobhlhgj,nijlf,i,gaemagobjfc,dg,g,jhlelodgeekj,hcimohlni,fdoiohikhacgb,k,doiaigclm,bdfaoncbhfkdbjd,f,jaikbciac,cjgadmfoodmba,molokllh,gfkngeebnggo,lahd,n,ehfngoc,lejfcee,kofhmoh,cgda,de,kljnicikjeh,edomdbibhif,jehdkgmmofihdi,hifcjkloebel,gcghgbemjege,kobhhefbbb,aaikgaolhllhlm,akg,kmmikgkhnn,dnamfhaf,mjhj,ifadcgmgjaa,acnjehgkflgkd,bjj,maihjn,ojakklhl,ign,jhd,kndkhbebgh,amljjfeahcdlfdg,fnboolobch,gcclgcoaojc,kfokbbkllmcd,fec,dljma,noa,cfjie,fohhemkka,bfaldajf,nbk,kmbnjoalnhki,ccieabbnlhbjmj,nmacelialookal,hdlefnbmgklo,bfbblofk,doohocnadd,klmed,e,hkkcmbljlojkghm,jjiadlgf,ogadjhambjikce,bglghjndlk,gackokkbhj,oofohdogb,leiolllnjj,edekdnibja,gjhglilocif,ccfnfjalchc,gl,ihee,cfgccdmecem,mdmcdgjelhgk,laboglchdhbk,ajmiim,cebhalkngloae,hgohednmkahdi,ddiecjnkmgbbei,ajaengmcdlbk,kgg,ndchkjdn,heklaamafiomea,ehg,imelcifnhkae,hcgadilb,elndjcodnhcc,nkjd,gjnfkogkjeobo,eolega,lm,jddfkfbbbhia,cddmfeckheeo,bfnmaalmjdb,fbcg,ko,mojfj,kk,bbljjnnikdhg,l,calbc,mkekn,ejlhdk,hkebdiebecf,emhelbbda,mlba,ckjmih,odfacclfl,lgfjjbgookmnoe,begnkogf,gakojeblk,bfflcmdko,cfdclljcg,ho,fo,acmi,oemknmffgcio,mlkhk,kfhkndmdojhidg,ckfcibmnikn,dgoecamdliaeeoa,ocealkbbec,kbmmihb,ncikad,hi,nccjbnldneijc,hgiccigeehmdl,dlfmjhmioa,kmff,gfhkd,okiamg,ekdbamm,fc,neg,cfmo,ccgahikbbl,khhoc,elbg,cbghbacjbfm,jkagbmfgemjfg,ijceidhhajmja,imibemhdg,ja,idkfd,ndogdkjjkf,fhic,ooajkki,fdnjhh,ba,jdlnidngkfffbmi,jddjfnnjoidcnm,kghljjikbacd,idllbbn,d,mgkajbnjedeiee,fbllleanknmoomb,lom,kofjmmjm,mcdlbglonin,gcnboanh,fggii,fdkbmic,bbiln,cdjcjhonjgiagkb,kooenbeoongcle,cecnlfbaanckdkj,fejlmog,fanekdneoaammb,maojbcegdamn,bcmanmjdeabdo,amloj,adgoej,jh,fhf,cogdljlgek,o,joeiajlioggj,oncal,lbgg,elainnbffk,hbdi,femcanllndoh,ke,hmib,nagfahhljh,ibifdlfeechcbal,knec,oegfcghlgalcnno,abiefmjldmln,mlfglgni,jkofhjeb,ifjbneblfldjel,nahhcimkjhjgb,cdgkbn,nnklfbeecgedie,gmllmjbodhgllc,hogollongjo,fmoinacebll,fkngbganmh,jgdblmhlmfij,fkkdjknahamcfb,aieakdokibj,hddlcdiailhd,iajhmg,jenocgo,embdib,dghbmljjogka,bahcggjgmlf,fb,jldkcfom,mfi,kdkke,odhbl,jin,kcjmkggcmnami,kofig,bid,ohnohi,fcbojdgoaoa,dj,ifkbmbod,dhdedohlghk,nmkeakohicfdjf,ahbifnnoaldgbj,egldeibiinoac,iehfhjjjmil,bmeimi,ombngooicknel,lfdkngobmik,ifjcjkfnmgjcnmi,fmf,aoeaa,an,ffgddcjblehhggo,hijfdcchdilcl,hacbaamkhblnkk,najefebghcbkjfl,hcnnlogjfmmjcma,njgcogemlnohl,ihejh,ej,ofn,ggcklj,omah,hg,obk,giig,cklna,lihaiollfnem,ionlnlhjckf,cfdlijnmgjoebl,dloehimen,acggkacahfhkdne,iecd,gn,odgbnalk,ahfhcd,dghlag,bchfe,dldblmnbifnmlo,cffhbijal,dbddifnojfibha,mhh,cjjol,fed,bhcnf,ciiibbedklnnk,ikniooicmm,ejf,ammeennkcdgbjco,jmhmd,cek,bjbhcmda,kfjmhbf,chjmmnea,ifccifn,naedmco,iohchafbega,kjejfhbco,anlhhhhg | true "
            }
    )
    void custom(String text, String words, boolean expected) {
        verify(text, words, expected);
    }

    @ParameterizedTest
    @CsvSource(
            delimiter = '|',
            value = {
                    " aaaaaaaaaaaaaaaaaaaaaaaaaaaab | a,aa,aaa,aaaa,aaaaa,aaaaaa,aaaaaaa | false ",
                    " aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab | a,aa,aaa,aaaa,aaaaa,aaaaaa,aaaaaaa,aaaaaaaa | false ",
                    " aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab | a,aa,aaa,aaaa,aaaaa,aaaaaa,aaaaaaa,aaaaaaaa,aaaaaaaaa,aaaaaaaaaa | false "
            }
    )
    void timeLimitExceeded(String text, String words, boolean expected) {
        var dictionary = Arrays.asList(words.split(","));
        var result = new WordBreak.DynamicProgramming().wordBreak(text, dictionary);
        var result2 = new WordBreak.SimpleAndEfficient().wordBreak(text, dictionary);
        assertEquals(expected, result);
        assertEquals(expected, result2);
    }

    private void verify(String text, String words, boolean expected) {
        var wordDict = Arrays.asList(words.split(","));
        var result = solution.wordBreak(text, wordDict);
        assertEquals(expected, result);
    }

}