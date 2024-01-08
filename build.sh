# Windows-compatible script using Git Bash

function main() {
    cd ./AUI_Lab-order && ./build.sh && cd ..
    cd ./AUI_Lab-client && ./build.sh && cd ..
    cd ./AUI_Lab-gateway && ./build.sh && cd ..
    cd ./AUI_Lab-ng && ./build.sh && cd ..

     read -p "Press Enter to continue..."
}

main "$@"