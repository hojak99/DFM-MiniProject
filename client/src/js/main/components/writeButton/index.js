import React from 'react'

const WriteButton = () =>{

    const handleClickWriteButton = () =>{
        location.href = "write.html";
    };

    return (
        <div className="global-write-button" onClick={handleClickWriteButton}>
            <img src="../img/add@2x.png"/>
        </div>
    );
};
export default WriteButton