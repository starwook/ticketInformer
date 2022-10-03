var genre =[0,0,0,0,0,0,0,0];
var sourceFlag ={
    INTERPARK :0,
    TICKETLINK:0,
    PLAYKFA:0
}
var sectionNum =1;
var genreNum=1;
var itemArray = document.querySelector("#itemList");
var newSection;
var newGenre;
function showItems(items){
    for(let i=0;i<items.length;i++){
        addSection(items[i].itemSource.toString(),sourceFlag[items[i].itemSource.toString()],items[i].itemGenre.toString());
        var itemName = JSON.stringify(items[i].name);
        var itemTime = JSON.stringify(items[i].date);
        var itemRank = JSON.stringify(items[i].rank)
        itemName = itemName.replace(/\"/g," ");
        itemTime = itemTime.replace(/\"/g," ");
        console.log(itemName);
        var newList = document.createElement("li");
        var imageBox = document.createElement("div");

        //이미지 박스
        imageBox.className = "imageBox";
        var imageTag = document.createElement("img");
        imageTag.src = items[i].imgUrl;
        imageBox.appendChild(imageTag);
        if(itemRank !=0){
            var rank = document.createElement("div");
            rank.className = "itemRank";
            rank.append(document.createTextNode(itemRank));
            imageBox.appendChild(rank);
        }


        newList.style.listStyle ="none";
        newList.appendChild(imageBox);




        newList.appendChild(document.createElement("br"));
        newList.appendChild(document.createTextNode(itemName));
        newList.appendChild(document.createElement("br"));
        newList.appendChild(document.createTextNode(itemTime));
        newGenre.appendChild(newList);
    }
}
function addSection(itemSource,flag,itemGenre){
    if(!flag){
        flag = true;
        newSection =document.createElement("div");
        newSection.className = "newSection"+sectionNum++;
        var newHeader =document.createElement("div");
        newHeader.className="sectionHeader";
        newHeader.append(document.createTextNode(changeToKorean(itemSource)));
        newSection.appendChild(newHeader);
        itemArray.appendChild(newSection);
        sourceFlag[itemSource] =1;
        genre.fill(0);
    }
    if(genreFlag(itemGenre)){
        newGenre = document.createElement("div");
        newGenre.className ="newGenre"+genreNum++;
        var newGenreHeader = document.createElement("div");
        newGenreHeader.className ="genreHeader";
        newGenreHeader.append(document.createTextNode(itemGenre));
        newGenre.append(newGenreHeader);
        newSection.appendChild(newGenre);
    }
}



function genreFlag(genreName){
    if(genreName == "MUSICAL"){
        if(!genre[0]){
            genre[0] =1;
            return true;
        }
        return false;
    }
    if(genreName == "CONCERT"){
        if(!genre[1]){
            genre[1] =1;
            return true;
        }
        return false;

    }
    if(genreName =="CLASSIC"){
        if(!genre[2]){
            genre[2] =1;
            return true;
        }
        return false;

    }
    if(genreName=="FAMILY"){
        if(!genre[3]){
            genre[3] =1;
            return true;
        }
        return false;

    }
    if(genreName =="FESTIVAL"){
        if(!genre[4]){
            genre[4] =1;
            return true;
        }
        return false;

    }
    if(genreName =="LEISURE"){
        if(!genre[5]){
            genre[5] =1;
            return true;
        }
        return false;

    }
    if(genreName =="SPORTS"){
        if(!genre[6]){
            genre[6] =1;
            return true;
        }
        return false;

    }
    if(genreName =="THEATER"){
        if(!genre[7]){
            genre[7] =1;
            return true;
        }
        return false;

    }
}
function changeToKorean(itemSource){
    if(itemSource=="INTERPARK"){
        itemSource= "인터파크";
    }
    if(itemSource=="TICKETLINK"){
        itemSource ="티켓링크"
    }
    return itemSource;

}