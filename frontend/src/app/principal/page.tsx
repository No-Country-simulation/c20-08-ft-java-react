import Image from "next/image";
import Niles from '../../assets/svg/Niles_1.svg';
import ReminderBankList from "@/UI/Components/reminderBankList";
import ReminderIDList from "@/UI/Components/reminderIDList";
import ReminderInvoicesList from "@/UI/Components/reminderInvoicesList";

export default function Principal(){
    
    return(
        <>
            <div className="flex bg-grayN-100 flex-col pt-6">
                <div className="m-auto w-11/12 grid place-content-center">


{/* ------------------------------------With Data------------------------------------------------------ */}

                    <div className="grid grid-cols-1 md:grid-cols-2 justify-items-stretch">
                        <div className="justify-self-center md:justify-self-end">
                            <Image className="w-56 md:w-64" src={Niles} alt="logo" />
                        </div>
                        <div className="justify-self-center md:justify-self-start w-80 md:w-96 p-5 place-content-center ">
                            Ah, there you are! Welcome, welcome! It's an absolute pleasure to see you’ve finally decided to join us. I trust the wait was worth every second of my anticipation
                        </div>
                    </div>
                    <h3 className="text-center md:text-left text-lg font-bold text-grayN-600 pt-4">
                        Banca
                    </h3>
                    <div className="py-4">
                        <hr className="border border-grayN-600" />
                    </div>
                    <div className="-space-y-16 md:space-y-0 grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-3">
                        <ReminderBankList/>
                    </div>
                    <h3 className="text-center md:text-left text-lg font-bold text-grayN-600 pt-4">
                        Identificaciones
                    </h3>
                    <div className="py-4">
                        <hr className="border border-grayN-600" />
                    </div>
                    <div className="-space-y-16 md:space-y-0 grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-3">
                        <ReminderIDList/>
                    </div>
                    <h3 className="text-center md:text-left text-lg font-bold text-grayN-600 pt-4">
                        Facturas
                    </h3>
                    <div className="py-4">
                        <hr className="border border-grayN-600" />
                    </div>
                    <div className="-space-y-16 md:space-y-0 grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-3">
                        <ReminderInvoicesList/>
                    </div>


{/* ------------------------------------Empty Princiapl------------------------------------------------------ */}

                    <div className="grid place-content-center h-screen">
                        <Image className="w-72 md:w-96" src={Niles} alt="logo" />
                        <span className="text-grayN-600 text-2xl md:text-4xl text-center font-semibold">¿Qué desea recordar?</span>
                    </div>


{/* ------------------------------------Floating button------------------------------------------------------ */}

                    <div className="fixed bottom-0 right-0 p-8 md:p-14">
                        <div className="size-16 md:size-20 bg-grayN-600 text-grayN-100 rounded-full flex items-center justify-center cursor-pointer transform transition duration-150 hover:scale-110">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" className="size-12 md:size-16">
                                <path fillRule="evenodd" d="M12 3.75a.75.75 0 0 1 .75.75v6.75h6.75a.75.75 0 0 1 0 1.5h-6.75v6.75a.75.75 0 0 1-1.5 0v-6.75H4.5a.75.75 0 0 1 0-1.5h6.75V4.5a.75.75 0 0 1 .75-.75Z" clipRule="evenodd" />
                            </svg>
                        </div>
                    </div>


                </div>
            </div>
        </>
    )
}