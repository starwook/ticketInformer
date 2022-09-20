var genre =[0,0,0,0,0,0,0,0];
function showItems(items){

    var itemList = document.querySelector("#itemList");
    var ticketLinkFlag = false;
    var playKfaFlag = false;
    var interParkFlag = false;
    for(let i=0;i<items.length;i++){
        var newSection;
        if(items[i].itemSource.toString() == "TICKETLINK"){
            if(!ticketLinkFlag){
                newSection =document.createElement("section");
                var newHeader =document.createElement("h2");
                newHeader.append(document.createTextNode("TICKETLINK"));
                newSection.appendChild(newHeader);
                itemList.appendChild(newSection);
                ticketLinkFlag = true;
                genre.fill(0);
            }
            // if(genreFlag(items[i].itemGenre.toString())){
            //     var newGenre = document.createElement("h3");
            //     newGenre.appendChild(document.createTextNode(items[i].itemGenre.toString()));
            //     newSection.appendChild(newGenre);
            // }
        }
        if(items[i].itemSource.toString() == "PLAYKFA"){

            if(!playKfaFlag){
                newSection =document.createElement("section");
                var newHeader =document.createElement("h2");
                newHeader.append(document.createTextNode("PLAYKFA"));
                newSection.appendChild(newHeader);
                itemList.appendChild(newSection);
                playKfaFlag = true;
                genre.fill(0);
            }
            // if(genreFlag(items[i].itemGenre.toString())){
            //     var newGenre = document.createElement("h3");
            //     newGenre.appendChild(document.createTextNode(items[i].itemGenre.toString()));
            //     itemList.appendChild(newGenre);
            // }
        }
        if(items[i].itemSource.toString() == "INTERPARK"){
            if(!interParkFlag){
                newSection =document.createElement("section");
                var newHeader =document.createElement("h2");
                newHeader.append(document.createTextNode("INTERPARK"));
                newSection.appendChild(newHeader);
                itemList.appendChild(newSection);
                interParkFlag = true;
                genre.fill(0);
            }
            // if(genreFlag(items[i].itemGenre.toString())){
            //     var newGenre = document.createElement("h3");
            //     newGenre.appendChild(document.createTextNode(items[i].itemGenre.toString()));
            //     itemList.appendChild(newGenre);
            // }
        }
        var itemName = JSON.stringify(items[i].name);
        var itemTime = JSON.stringify(items[i].date);
        var itemRank = JSON.stringify(items[i].rank)
        itemName = itemName.replace(/\"/g," ");
        itemTime = itemTime.replace(/\"/g," ");
        console.log(itemName);
        var newList = document.createElement("li");
        var imageTag = document.createElement("img");
        imageTag.src = items[i].imgUrl;

        newList.style.listStyle ="none";

        if(itemRank !=0){
            newList.appendChild(document.createTextNode(itemRank));
        }
        console.log(items[i].imgUrl);
        newList.appendChild(imageTag);
        newList.appendChild(document.createElement("br"));
        newList.appendChild(document.createTextNode(itemName));
        newList.appendChild(document.createElement("br"));
        newList.appendChild(document.createTextNode(itemTime));
        newSection.appendChild(newList);


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