

export default function Card () {
    return (
        <div className="md:bg-white w-[358px] h-[220px] lg:w-[383px] lg:h-[250px] grid place-content-center rounded-md">
            <div className="border border-gray-300
                            shadow-[0px_15px_25px_0px_rgba(0,0,0,0.3)] md:shadow-inner
                            grid w-[315px] h-[193px] lg:w-[335px] lg:h-[213px]
                            rounded-xl
                            bg-gradient-to-b from-grayN-100 to-green-700
                            cursor-pointer
                            transform transition duration-500 hover:scale-110 hover:z-10
                            overflow-hidden">
                <div className="grid grid-cols-6">
                    <div className="col-start-6 mt-3 ms-3 h-1">
                        <div className="size-8 rounded-full bg-green-500"></div>
                    </div>
                    <div className="col-start-1 col-end-7">
                        <div className="bg-grayN-100 w-[313px] lg:w-[334px] h-[44px] place-content-center text-sm ps-4">Mi tarjeta para recordar</div>
                    </div>
                    <div className="col-span-4 text-white text-sm ps-4">Expires: 15 Sep de 2025</div>
                    <div className="col-span-2 text-white text-sm">...9834</div>
                </div>
            </div>
        </div>
    )
}