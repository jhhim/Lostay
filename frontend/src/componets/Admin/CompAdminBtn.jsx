import React from 'react'


export default function CompAdminBtn({children}, props) {





    //children: 상속 넘겨줄 것!==innerHTML
    //<CompAdminBtn>'children'</CompAdminBtn>

  return (  //Customized Button
    <>
        <button className='comp--admin--btn--container' onClick={props.click}>{children}</button>
    </>
  )
}
